package com.esteban.flightservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.flightservice.entity.Flight;
import com.esteban.flightservice.repository.FlightRespository;
import com.esteban.flightservice.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRespository flightRespository;

	@Override
	public List<Flight> getAllFlights() {
		return flightRespository.findAll();
	}

	@Override
	public Flight createFlight(Flight flight) {
		return flightRespository.save(flight);
	}

	@Override
	public Flight getFlightById(Long id) {
		return flightRespository.findById(id).orElse(null);
	}

	@Override
	public List<Flight> getFlightsByUserId(Long userId) {
		return flightRespository.findByUserId(userId);
	}

	@Override
	public List<Flight> getFlightsByCityId(Long cityId) {
		return flightRespository.findByCityId(cityId);
				
	}

	@Override
	public List<Flight> getFlightsByPurchaseId(Long purchaseId) {
		return flightRespository.findByPurchaseId(purchaseId);
	}
	
	
	

}
