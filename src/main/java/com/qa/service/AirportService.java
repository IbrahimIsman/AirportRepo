package com.qa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.entity.Airport;
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
	

	

}
