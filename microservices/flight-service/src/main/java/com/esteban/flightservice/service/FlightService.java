package com.esteban.flightservice.service;

import java.util.List;

import com.esteban.flightservice.entity.Flight;


public interface FlightService {

	List<Flight> getAllFlights();

	Flight createFlight(Flight flight);

	Flight getFlightById(Long id);

	List<Flight> getFlightsByUserId(Long userId);

	List<Flight> getFlightsByCityId(Long cityId);

	List<Flight> getFlightsByPurchaseId(Long purchaseId);

	Double setPricePerUser (Double basePrice, int age, boolean luggage);
}
