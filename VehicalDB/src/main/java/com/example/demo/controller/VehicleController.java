package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService service;
	
	@PostMapping("/addVehicle")
	ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(service.addVehicle(v),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteVehicle")
	ResponseEntity<Vehicle> deleteVehicle(@RequestParam Integer vid){
		return new ResponseEntity<Vehicle>(service.deleteVehicle(vid),HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleById")
	ResponseEntity<Vehicle> getVehicleById(@RequestHeader int vid){
		return new ResponseEntity<Vehicle>(service.getVehicleById(vid),HttpStatus.FOUND);
	}
	
	@GetMapping("/getVehicleByColor")
	ResponseEntity<List<Vehicle>> getVehicleByColor(@RequestHeader String vcolor){
		return new ResponseEntity<List<Vehicle>>(service.getVehicleByColor(vcolor),HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleByPrice")
	ResponseEntity<List<Vehicle>> getVehicleByPrice(){
		return new ResponseEntity<List<Vehicle>>(service.getVehicleByPrice(),HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleMorePrice")
	ResponseEntity<List<Vehicle>> getVehicleMorePrice(){
		return new ResponseEntity<List<Vehicle>>(service.getVehicleMorePrice(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllVehicle")
	ResponseEntity<List<Vehicle>> getAllVehicle(){
		return new ResponseEntity<List<Vehicle>>(service.getAllVehicle(),HttpStatus.OK);
	}
	
	@PutMapping("/modifyVehicle")
	ResponseEntity<Vehicle> modifyVehicle(@RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(service.modifyVehicle(v),HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleByPrice2")
	ResponseEntity<List<Vehicle>> getVehicleByPrice2(){
		return new ResponseEntity<List<Vehicle>>(service.getVehicleByPrice2(),HttpStatus.FOUND);
	}
}
