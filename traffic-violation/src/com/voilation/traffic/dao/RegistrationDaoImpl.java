package com.voilation.traffic.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.voilation.traffic.model.Registration;
import com.voilation.traffic.util.ConnectionDb;

public class RegistrationDaoImpl implements RegistrationDao {

    private Connection con;
    public RegistrationDaoImpl() {
        con = ConnectionDb.getConnection();
    }

    @Override
    public int save(Registration reg) {
        try {
            Statement statement = con.createStatement();
            String query = "INSERT INTO REGISTRATION( NAME, ADDRESS, CONTACT_NO, EMAIL_ID, USERNAME, PASSWORD, LEVEL, ACTIVE, DESIGNATION) " +
                    "VALUES('"+reg.getName()+"','"+reg.getAddress()+"','"+reg.getContactNo()+"','"
                    +reg.getEmailId()+"','"+reg.getUsername()+"','"+reg.getPassword()+"','"
                    +reg.getLevel()+"','"+reg.getStatus()+"','"+reg.getDesignation()+"')";
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
