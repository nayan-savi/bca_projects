package com.voilation.traffic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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


}
