package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.ArrayList;
import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.City;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flight;

public interface FlightService {

	Flight createFlight(Flight flights);
	
	List<Flight> findAllFlights();
	
	Flight updateFlight(Flight flights);

	boolean deleteFlight(Long id);
	
	// Looks for all the available flights with the selected departure city
	public static List<Flight> findAvailableFlights(String departureCity){
		
		List<Flight> flights.findAllFlights();
		
		for (Flight flight :flights) {
			City city = flight.getDepartureCity();
			if (city.getName() == departureCity) {
				flights.remove(flights.indexOf(flights));
			}
		}

		return flights;
	};

}
