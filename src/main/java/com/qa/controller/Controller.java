package com.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.Airport;
import com.qa.service.AirportService;

@RestController
public class Controller {

	private AirportService airport;

	@Autowired
	public Controller(AirportService airport) {
		super();
		this.airport = airport;
	}
	
	@PostMapping("/addToAirport")
	public ResponseEntity<Airport> addToAirport (@RequestBody Airport aeroplane){
	   return new ResponseEntity<Airport> (this.airport.addAeroplane(aeroplane), HttpStatus.CREATED);
	}
	
}
