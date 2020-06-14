package com.system.bugtracker.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.system.bugtracker.model.Employee;
import com.system.bugtracker.util.ConnectionDb;


public class LoginDaoImpl implements LoginDao {

    private Connection con;

    public LoginDaoImpl() {
        con = ConnectionDb.getConnection();
    }

    @Override
    public Employee login(String username, String password) {
    	Employee employee = new Employee();
        String query;
        try {
            Statement stmt = con.createStatement();
            query = "SELECT * FROM EMPLOYEE WHERE USERNAME='" + username + "' and PASSWORD='" + password + "' and active = 'YES'";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                employee.setUsername(username);
                employee.setEmployeeId(result.getInt("EMPLOYEEID"));
                employee.setName(result.getString("NAME"));
                employee.setEmailId(result.getString("EMAILID"));
                employee.setLevel(result.getInt("LEVEL"));
                employee.setActive(result.getString("ACTIVE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
