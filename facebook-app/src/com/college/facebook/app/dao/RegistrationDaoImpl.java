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
import java.util.UUID;

public class RegistrationDaoImpl implements RegistrationDao {

    private Connection connection;

    public RegistrationDaoImpl(HttpServletRequest request) {
        connection = (Connection) request.getServletContext().getAttribute(FacebookConst.CONNECTION);
    }

    @Override
    public int save(Registration reg) {
        try {
            final UUID uuid = UUID.randomUUID();
            Statement statement = connection.createStatement();
            String regQuery = "INSERT INTO REGISTRATION(USERID, NAME, ADDRESS, CONTACTNO, EMAILID, USERNAME, PASSWORD, ACTIVE) " +
                    "VALUES ('" + uuid + "','" + reg.getName() + "','" + reg.getAddress() + "','" + reg.getContactNo() + "','"
                    + reg.getEmailId() + "','" + reg.getUsername() + "',MD5('" + reg.getPassword() + "'), TRUE)";

            String loginQuery = "INSERT INTO LOGIN(USERID, NAME, CONTACTNO, EMAILID, USERNAME, PASSWORD, ACTIVE, ONLINE) " +
                    "VALUES ('" + uuid + "','" + reg.getName() + "','" + reg.getContactNo() + "','"
                    + reg.getEmailId() + "','" + reg.getUsername() + "',MD5('" + reg.getPassword() + "'), TRUE, FALSE )";

            statement.addBatch(regQuery);
            statement.addBatch(loginQuery);
            int[] rows = statement.executeBatch();
            return rows.length != 0 ? (rows[0] * rows[1]) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Registration> getActiveUsers(String userId) {
        try {
            List<Registration> registrations = new ArrayList<>();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM REGISTRATION WHERE ACTIVE = TRUE AND userid <> '"+userId+"'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Registration registration = new Registration();
                registration.setUserId(rs.getString("USERID"));
                registration.setUsername(rs.getString("USERNAME"));
                registration.setEmailId(rs.getString("EMAILID"));
                registration.setContactNo(rs.getString("CONTACTNO"));
                registrations.add(registration);
            }
            return registrations;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
