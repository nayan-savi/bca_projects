package com.voilation.traffic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.voilation.traffic.model.Registration;
import com.voilation.traffic.model.Vehicle;
import com.voilation.traffic.util.ConnectionDb;

public class VehicleDaoImpl implements VehicleDao {

	private Statement stmt;

    public VehicleDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int saveVehicle(Vehicle vehicle) {
		try {
            String query = "INSERT INTO VEHICLE (VEHICLEID,OWNERNAME,REGNO,REGDATE,DLNO,ADDRESS,CHARSSISNO,ENGINENO,MODEL,COLOR,STATUS,COMMENT) VALUES ('"
            				+vehicle.getVehicleId()+ "','" +vehicle.getOwnerName()+ "','" 
            				+vehicle.getRegNo()+ "','" +vehicle.getRegDate()+ "','" +vehicle.getDlNo()+ "','" +vehicle.getAddress()+ "','" +vehicle.getCharssisNo()+ "','" +vehicle.getEngineNo()+ "','" +vehicle.getModel()+ "','" +vehicle.getColor()+ "','" +vehicle.getStatus()+ "','" +vehicle.getComment()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
    public List<Vehicle> viewVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            String query = "SELECT * FROM VEHICLE";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
				vehicle.setVehicleId(Integer.parseInt(rs.getString("VEHICLEID")));
				vehicle.setOwnerName(rs.getString("OWNERNAME"));
				vehicle.setRegNo(rs.getString("REGNO"));
				vehicle.setRegDate(rs.getString("REGDATE"));
				vehicle.setDlNo(rs.getString("DLNO"));
				vehicle.setAddress(rs.getString("ADDRESS"));
				vehicle.setCharssisNo(rs.getString("CHARSSISNO"));
				vehicle.setEngineNo(rs.getString("ENGINENO"));
				vehicle.setModel(rs.getString("MODEL"));
				vehicle.setColor(rs.getString("COLOR"));
				vehicle.setStatus(rs.getString("STATUS"));
				vehicle.setComment(rs.getString("COMMENT"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
	
	@Override
    public List<Registration> viewEmployees() {
        List<Registration> registrations = new ArrayList<>();
        try {
            String query = "SELECT * FROM REGISTRATION WHERE LEVEL = 2";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	Registration registration = new Registration();
            	registration.setName(rs.getString("NAME"));
            	registration.setAddress(rs.getString("ADDRESS"));
            	registration.setContactNo(rs.getString("CONTACT_NO"));
            	registration.setEmailId(rs.getString("EMAIL_ID"));
            	registration.setUsername(rs.getString("USERNAME"));
            	registration.setLevel(rs.getInt("LEVEL"));
            	registration.setStatus(rs.getString("ACTIVE"));
            	registration.setDesignation(rs.getString("DESIGNATION"));
				registrations.add(registration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }

	@Override
    public Vehicle getVehicleById(String id) {
        Vehicle vehicle= null;
        try {
            String query = "SELECT * FROM VEHICLE WHERE VEHICLEID = ('"+id+"')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	vehicle = new Vehicle();
            	vehicle.setVehicleId(rs.getInt("VEHICLEID"));
            	vehicle.setOwnerName(rs.getString("OWNERNAME"));
            	vehicle.setRegNo(rs.getString("REGNO"));
            	vehicle.setRegDate(rs.getString("REGDATE"));
            	vehicle.setDlNo(rs.getString("DLNO"));
            	vehicle.setAddress(rs.getString("ADDRESS"));
            	vehicle.setCharssisNo(rs.getString("CHARSSISNO"));
            	vehicle.setEngineNo(rs.getString("ENGINENO"));
            	vehicle.setModel(rs.getString("MODEL"));
            	vehicle.setColor(rs.getString("COLOR"));
            	vehicle.setStatus(rs.getString("STATUS"));
            	vehicle.setComment(rs.getString("COMMENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

	@Override
	public int updateVehicle(Vehicle vehicle) {
		try {
            String query = "update VEHICLE set MODEL = '"+vehicle.getModel()+"', COLOR = '"+vehicle.getColor()+"', COMMENT = '"+vehicle.getComment()
            +"', ADDRESS= '"+vehicle.getAddress()+"' where vehicleId = '"+vehicle.getVehicleId()+"'";
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}

	@Override
	public Vehicle getVehicleByNo(String vehicleNo) {
		Vehicle vehicle= null;
        try {
            String query = "SELECT * FROM VEHICLE WHERE REGNO = ('"+vehicleNo+"') AND STATUS = 'ACTIVE'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	vehicle = new Vehicle();
            	vehicle.setVehicleId(rs.getInt("VEHICLEID"));
            	vehicle.setOwnerName(rs.getString("OWNERNAME"));
            	vehicle.setRegNo(rs.getString("REGNO"));
            	vehicle.setRegDate(rs.getString("REGDATE"));
            	vehicle.setDlNo(rs.getString("DLNO"));
            	vehicle.setAddress(rs.getString("ADDRESS"));
            	vehicle.setCharssisNo(rs.getString("CHARSSISNO"));
            	vehicle.setEngineNo(rs.getString("ENGINENO"));
            	vehicle.setModel(rs.getString("MODEL"));
            	vehicle.setColor(rs.getString("COLOR"));
            	vehicle.setStatus(rs.getString("STATUS"));
            	vehicle.setComment(rs.getString("COMMENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
	}

	@Override
	public int saveEmployee(Registration employee) {
		try {
            String query = "INSERT INTO REGISTRATION (NAME,ADDRESS,CONTACT_NO,EMAIL_ID,USERNAME,LEVEL,ACTIVE,DESIGNATION) VALUES ('"
            				+employee.getName()+ "','" 
            				+employee.getAddress()+ "','" 
            				+employee.getContactNo()+ "','" 
            				+employee.getEmailId()+ "','" 
            				+employee.getUsername()+ "','" 
            				+employee.getLevel()+ "','" 
            				+employee.getStatus()+ "','" 
            				+employee.getDesignation()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public Registration getEmployeeByUsername(String username) {
		Registration registration = null;
        try {
            String query = "SELECT * FROM REGISTRATION WHERE USERNAME = '"+username+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	registration = new Registration();
            	registration.setName(rs.getString("NAME"));
            	registration.setAddress(rs.getString("ADDRESS"));
            	registration.setContactNo(rs.getString("CONTACT_NO"));
            	registration.setEmailId(rs.getString("EMAIL_ID"));
            	registration.setUsername(rs.getString("USERNAME"));
            	registration.setLevel(rs.getInt("LEVEL"));
            	registration.setStatus(rs.getString("ACTIVE"));
            	registration.setDesignation(rs.getString("DESIGNATION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registration;
	}
	
	@Override
	public int updateEmployee(Registration employee) {
		try {
            String query = "UPDATE REGISTRATION SET NAME = '"+employee.getName()
            				+"',ADDRESS='"+employee.getAddress()
            				+"' ,CONTACT_NO='"+employee.getContactNo()+"',EMAIL_ID ='"+employee.getEmailId()
            				+"', ACTIVE ='"+employee.getStatus()
            				+"' ,DESIGNATION ='"+employee.getDesignation()+"' where username = '"+employee.getUsername()+"'";
            				
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}


}
