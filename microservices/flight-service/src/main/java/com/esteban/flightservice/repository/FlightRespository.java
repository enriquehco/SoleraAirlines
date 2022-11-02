package com.esteban.flightservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esteban.flightservice.entity.Flight;

public interface FlightRespository extends JpaRepository<Flight, Long> {
	
	List<Flight> findByUserId(Long userId);
	List<Flight> findByCityId(Long cityId);
}
