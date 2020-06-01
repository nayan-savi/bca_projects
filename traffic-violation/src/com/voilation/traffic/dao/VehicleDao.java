package com.voilation.traffic.dao;

import java.util.List;

import com.voilation.traffic.model.Vehicle;

public interface VehicleDao {

	int saveVehicle(Vehicle vehicle);
	
    List<Vehicle> viewVehicles();

    Vehicle getVehicleById(String parameter);

    int updateVehicle(Vehicle vehicle);

	Vehicle getVehicleByNo(String vehicleNo);

}
