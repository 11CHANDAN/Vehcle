package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	@Query(value="select * from Vehicle where vcolor=?1",nativeQuery=true)
	 List<Vehicle> getVehicleByColor(String vcolor);
	
	@Query(value="select * from Vehicle order by vprice",nativeQuery=true)
	List<Vehicle> getVehicleByPrice();
	
	@Query(value="select * from Vehicle",nativeQuery=true)
	List<Vehicle> getAllVehicle();
	
	@Query(value="select * from Vehicle where vprice>=1000000",nativeQuery=true)
	List<Vehicle> getVehicleByPrice1();
	
	@Query(value="select * from Vehicle order by vprice,vcolor",nativeQuery=true)
	List<Vehicle> getVehiclePriceColor();
}
