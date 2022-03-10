package com.qa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.entity.Airport;
import com.qa.exceptions.IdNotFoundException;
import com.qa.repo.AirportRepo;

@Service
public class AirportService {
	
	private AirportRepo repo;

	public AirportService(AirportRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Airport addAeroplane(Airport aeroplane) {
		return this.repo.save(aeroplane);
	}
	
	public List<Airport> getAll(){
		return this.repo.findAll();
	}
	
	public Airport getById(Integer id) {
		return this.repo.findById(id).orElseThrow(() -> new IdNotFoundException("cant find the person"));
	}
	
	public List<Airport> findPlaneByCapacity (int capacity){
		return this.repo.findAirportByCapacitySQL(capacity);
	}
	
	public List<Airport> findPlaneByPriceGreaterThan (float price){
		return this.repo.findAirportByPriceGreaterThan(price);
	}
	
	public Airport update(Integer id, Airport aeroplane) {
		
		Airport foundAeroplane = this.getById(id);
		
		foundAeroplane.setCapacity(aeroplane.getCapacity());
		foundAeroplane.setPrice(aeroplane.getPrice());
		foundAeroplane.setType(aeroplane.getType());
		
		return this.repo.save(foundAeroplane);
		
	}

	public Boolean delete(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
		
	}

}
