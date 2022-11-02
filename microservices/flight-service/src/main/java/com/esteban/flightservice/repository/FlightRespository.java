package com.esteban.flightservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esteban.flightservice.entity.Flight;

@Repository
public interface FlightRespository extends JpaRepository<Flight, Long> {

	List<Flight> findByUserId(Long userId);
	List<Flight> findByCityId(Long cityId);
	List<Flight> findByPurchaseId(Long purchaseId);
}
