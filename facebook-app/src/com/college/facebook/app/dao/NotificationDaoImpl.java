package com.college.facebook.app.dao;

import com.college.facebook.app.constant.FacebookConst;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.Registration;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {

    private Connection connection;

    public NotificationDaoImpl(HttpServletRequest request) {
        connection = (Connection) request.getServletContext().getAttribute(FacebookConst.CONNECTION);
    }

    @Override
    public List<Registration> getNotification(Login login) {
        try {
            List<Registration> registrations = new ArrayList<>();
            Statement statement = connection.createStatement();
            String query = "SELECT R.USERID, R.USERNAME, R.EMAILID, R.CONTACTNO FROM  FRIENDREQUESTS F" +
                    " JOIN REGISTRATION R ON R.USERID = F.USERID" +
                    " WHERE F.FRIENDID = '"+login.getUserId()+"'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Registration registration = getRegistration(rs);
                registrations.add(registration);
            }
            return registrations;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Registration getRegistration(ResultSet rs) throws SQLException {
        Registration registration = new Registration();
        registration.setUserId(rs.getString("USERID"));
        registration.setUsername(rs.getString("USERNAME"));
        registration.setEmailId(rs.getString("EMAILID"));
        registration.setContactNo(rs.getString("CONTACTNO"));
        return registration;
    }

    @Override
    public int confirmNotification(String userId, String friendId) {
        try {
            Statement statement = connection.createStatement();
            String query1 = "INSERT INTO LINKEDFRIENDS (USERID, REQUESTORID, ACCEPTEDDATE) VALUES ('"+userId+"','"+friendId+"', CURDATE())";
            String query2 = "INSERT INTO LINKEDFRIENDS (REQUESTORID, USERID, ACCEPTEDDATE) VALUES ('"+userId+"','"+friendId+"', CURDATE())";
            String query3 = "DELETE FROM FRIENDREQUESTS WHERE FRIENDID='"+userId+"' AND USERID = '"+friendId+"'";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.addBatch(query3);
            int[] ints = statement.executeBatch();
            return ints.length > 0 ? (ints[0] * ints[1] * ints[2]) : 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteNotification(String userId, String friendId) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM FRIENDREQUESTS WHERE FRIENDID='"+userId+"' AND USERID = '"+friendId+"'";
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
