package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flight;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.User;

public interface FlightService {

	Flight createFlight(Flight flight);

	static List<Flight> findAllFlights() {
		// TODO Auto-generated method stub
		return null;
	}

	Flight updateFlight(Flight flight);

	boolean deleteFlight(Long id);

	// Looks for all the available flights with the selected departure city
	public static List<Flight> findAvailableFlights(String departureCity){
		List<Flight> flights;
		flights = findAllFlights();

		for (Flight flight :flights) {
			if (flight.getDepartureCity() != departureCity) {
				flights.remove(flights.indexOf(flight));
			}
		}

		return flights;
	}

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

		double finalPrice = flight.getbasePrice() * discount;

		return finalPrice;
	}

}
