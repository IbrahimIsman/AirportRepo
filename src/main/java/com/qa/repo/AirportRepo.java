package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.entity.Airport;

public interface AirportRepo extends JpaRepository<Airport, Integer>{

}
