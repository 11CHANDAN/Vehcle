package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService {
	 Vehicle addVehicle(Vehicle v);
	 Vehicle deleteVehicle(Integer vid);
	 Vehicle getVehicleById(Integer vid);
	 List<Vehicle> getAllVehicle();
	 List<Vehicle> getVehicleByColor(String vcolor);
	 List<Vehicle> getVehicleByPrice();
	 List<Vehicle> getVehicleMorePrice();
	 Vehicle modifyVehicle(Vehicle v);
	 List<Vehicle> getVehicleByPrice2();
}
