package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flights;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Users;

public interface FlightsService {

	List<Flights> findAllFlights();

	Flights createFlight(Flights flights);

	boolean deleteFlight(Long id);

	Flights updateFlight(Flights flights);

}
