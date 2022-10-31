package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.FlightService;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flight;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<Flight> findAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public Flight createFlight(Flight flights) {
		return flightRepository.save(flights);
	}

	@Override
	public boolean deleteFlight(Long id) {
		if (flightRepository.existsById(id)) {
			flightRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Flight updateFlight(Flight flights) {
		return flightRepository.save(flights);
	}

}
