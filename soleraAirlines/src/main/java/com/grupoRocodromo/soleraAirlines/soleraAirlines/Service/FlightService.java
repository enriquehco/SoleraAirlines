package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flight;

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

}
