package com.college.facebook.app.dao;

import com.college.facebook.app.config.ConnectionListener;
import com.college.facebook.app.model.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImpl implements LoginDao {

    private Connection con;

    public LoginDaoImpl() {
        con = ConnectionListener.getConnection();
    }

    @Override
    public Login login(String username, String password) {
        Login login = new Login();
        String query;
        try {
            Statement stmt = con.createStatement();
            query = "SELECT * FROM LOGIN WHERE USERNAME='" + username + "' AND PASSWORD=MD5('" + password + "') and active = TRUE";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                login.setUserId(result.getString("USERID"));
                login.setUsername(result.getString("USERNAME"));
                login.setEmailId(result.getString("EMAILID"));
                login.setActive(result.getBoolean("ACTIVE"));
            }
            if(null != login.getUserId()) {
                String update = "UPDATE LOGIN SET ONLINE = TRUE WHERE USERID = '"+login.getUserId()+"'";
                stmt.executeUpdate(update);
            }
            return login;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
