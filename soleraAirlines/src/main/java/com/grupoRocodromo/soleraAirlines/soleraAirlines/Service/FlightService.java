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
	public static double getFinalPrice (Flight flight, List<User> users) {
		double discount = 1;
		
		for (User user :users) {
			if (user.getAge() < 2) {
				users.remove(users.indexOf(user));
			}
			else if (user.getAge() >= 2 && user.getAge() <= 9) {
				discount -= 0.1;
			}
		}
		
		if (discount <= 0) {
			discount = 0.2;
		}
		
		double finalPrice = flight.getbasePrice() * users.size() * discount;
		
		return finalPrice;
	}

}
