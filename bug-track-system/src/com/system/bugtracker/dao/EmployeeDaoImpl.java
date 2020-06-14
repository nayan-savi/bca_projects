package com.system.bugtracker.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.bugtracker.model.Employee;
import com.system.bugtracker.util.ConnectionDb;


public class EmployeeDaoImpl implements EmployeeDao {

    private Statement stmt;

    public EmployeeDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Employee reg) {
        try {
            String query = "INSERT INTO EMPLOYEE( NAME, ADDRESS, CONTACTNO, EMAILID, USERNAME, PASSWORD, LEVEL, ACTIVE) " +
                    "VALUES('"+reg.getName()+"','"+reg.getAddress()+"','"+reg.getContactNo()+"','"
                    +reg.getEmailId()+"','"+reg.getUsername()+"','"+reg.getPassword()+"','"
                    +reg.getLevel()+"','"+reg.getActive()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public List<Employee> viewEmployees(boolean active) {
        List<Employee> employees = new ArrayList<>();
        try {
        	
            String query = "SELECT * FROM EMPLOYEE WHERE ";
            if(active) {
            	query += " ACTIVE = 'YES' AND LEVEL NOT IN (1, 2)";
            } else {
            	query += "LEVEL <> 1";
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(Integer.parseInt(rs.getString("EMPLOYEEID")));
                employee.setName(rs.getString("NAME"));
				employee.setAddress(rs.getString("ADDRESS"));
				employee.setContactNo(rs.getString("CONTACTNO"));
				employee.setEmailId(rs.getString("EMAILID"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setLevel(Integer.parseInt(rs.getString("LEVEL")));
				employee.setActive(rs.getString("ACTIVE"));
				employee.setDesignation(rs.getString("DESIGNATION"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    @Override
    public Employee getEmployeeById(String id) {
        Employee employee = new Employee();
        try {
            String query = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ('"+id+"')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //employee.setEmployeeId(rs.getString("EMPLOYEEID"));
				employee.setName(rs.getString("NAME"));
				employee.setAddress(rs.getString("ADDRESS"));
				employee.setContactNo(rs.getString("CONTACTNO"));
				employee.setEmailId(rs.getString("EMAILID"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setLevel(Integer.parseInt(rs.getString("LEVEL")));
				employee.setActive(rs.getString("ACTIVE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    
    @Override
    public int updateEmployee(Employee employee) {
        try {
            String query = "UPDATE EMPLOYEE SET NAME = '"+employee.getName()+"', ADDRESS = '"
            +employee.getAddress()+"', CONTACTNO = '"+employee.getContactNo()+"', LEVEL = '"+employee.getLevel()
            +"', ACTIVE= '"+employee.getActive()+"' WHERE USERNAME = '"+employee.getUsername()+"'";
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int updatePwd(Employee employee) {
    	try {
            String query = "UPDATE EMPLOYEE SET PASSWORD = '"+employee.getPassword()
            				+"' where username = '"+employee.getUsername()+"'";
            				
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
    }
}
