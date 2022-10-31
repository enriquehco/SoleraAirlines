package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flight;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.User;

public interface FlightService {

	List<Flight> findAllFlights();

	Flight createFlight(Flight flights);

	boolean deleteFlight(Long id);

	Flight updateFlight(Flight flights);

}
