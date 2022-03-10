package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.entity.Airport;

public interface AirportRepo extends JpaRepository<Airport, Integer>{

	@Query(value = "SELECT * FROM airport WHERE capacity = ?1", nativeQuery=true)
	List<Airport> findAirportByCapacitySQL (int capacity);
	
	List<Airport> findAirportByPriceGreaterThan(float price);
}
