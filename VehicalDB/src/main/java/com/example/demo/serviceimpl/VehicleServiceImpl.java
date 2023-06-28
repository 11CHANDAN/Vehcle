package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
	@Autowired
	VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle v) {
		return repo.save(v);
	}

	@Override
	public Vehicle deleteVehicle(Integer vid) {
		Vehicle v=repo.findById(vid).orElse(null);
		if(v!=null) {
			repo.deleteById(v.getVid());
			return v;
		}
		else {
			throw new ResourceNotFoundException("Vehicle", "id",vid);
		}
	}

	@Override
	public Vehicle getVehicleById(Integer vid) {
		return repo.findById(vid).orElseThrow(() ->new ResourceNotFoundException("Vehicle","vid",vid));
	}

	@Override
	public List<Vehicle> getVehicleByColor(String vcolor) {
		return repo.getVehicleByColor(vcolor);
	}

	@Override
	public List<Vehicle> getVehicleByPrice() {
		return repo.getVehicleByPrice();
	}

	@Override
	public List<Vehicle> getVehicleMorePrice() {
		// TODO Auto-generated method stub
		return repo.getVehicleByPrice1();
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		return repo.getAllVehicle();
	}

	@Override
	public Vehicle modifyVehicle(Vehicle v) {
		Vehicle v1=repo.findById(v.getVid()).orElse(null);
		if(v1!=null) {
			v1.setVname(v.getVname());
			v1.setVcolor(v.getVcolor());
			v1.setVmodel(v.getVmodel());
			v1.setVprice(v.getVprice());
			return repo.save(v1);
		}
//		else {
//			return repo.save(v);
//		}
		throw new ResourceNotFoundException("Vehicle", "vid", v.getVid());
	}

	@Override
	public List<Vehicle> getVehicleByPrice2() {
		// TODO Auto-generated method stub
		return repo.getVehiclePriceColor();
	}

	

}
