package com.esteban.flightservice.service;

import java.util.List;

import com.esteban.flightservice.entity.Flight;


public interface FlightService {

	List<Flight> getAllFlights();

	Flight createFlight(Flight flight);

	Flight getFlightById(Long id);
	
	List<Flight> getFlightsByUserId(Long userId);

	List<Flight> getFlightsByCityId(Long cityId);
	
	// Sets final price depending on user data
	public static double setPricePerUser (Flight flight, int age, boolean luggage) {
		double discount = 1;

		if (age < 2) {
			discount = 0;
		}
		else if (age >= 2 && age <= 9) {
			discount -= 0.5;
		}

		if (luggage) {
			discount += 0.2;
		}

		double finalPrice = flight.getBasePrice() * discount;

		return finalPrice;
	}
}
