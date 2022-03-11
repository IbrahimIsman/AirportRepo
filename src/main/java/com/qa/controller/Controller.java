package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Airport>> getAllPlanes(){
	    return new ResponseEntity<List<Airport>>(this.airport.getAll(), HttpStatus.OK);	
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Airport> getById (@PathVariable Integer id){
	    return new ResponseEntity<Airport> (this.airport.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Airport> update (@PathVariable Integer id, Airport aeroplane ){
        return new ResponseEntity<Airport> (this.airport.update(id, aeroplane), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> update (@PathVariable Integer id){
	    return new ResponseEntity<Boolean> (this.airport.delete(id), HttpStatus.ACCEPTED);
	}
}
