package com.voilation.traffic.dao;


import java.sql.SQLException;
import java.sql.Statement;

import com.voilation.traffic.model.Registration;
import com.voilation.traffic.util.ConnectionDb;

public class RegistrationDaoImpl implements RegistrationDao {

    private Statement stmt;

    public RegistrationDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Registration reg) {
        try {
            String query = "INSERT INTO REGISTRATION( NAME, ADDRESS, CONTACT_NO, EMAIL_ID, USERNAME, PASSWORD, LEVEL, ACTIVE, DESIGNATION) " +
                    "VALUES('"+reg.getName()+"','"+reg.getAddress()+"','"+reg.getContactNo()+"','"
                    +reg.getEmailId()+"','"+reg.getUsername()+"','"+reg.getPassword()+"','"
                    +reg.getLevel()+"','"+reg.getStatus()+"','"+reg.getDesignation()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int updatePwd(Registration reg) {
    	try {
            String query = "UPDATE REGISTRATION SET PASSWORD = '"+reg.getPassword()
            				+"' where username = '"+reg.getUsername()+"'";
            				
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
    }
}
