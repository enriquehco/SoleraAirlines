package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flight;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.User;

public interface FlightsService {

	List<Flight> findAllFlights();

	Flight createFlight(Flight flights);

	boolean deleteFlight(Long id);

	Flight updateFlight(Flight flights);

}
