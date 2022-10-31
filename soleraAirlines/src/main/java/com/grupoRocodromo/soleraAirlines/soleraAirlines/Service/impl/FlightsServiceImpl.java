package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.FlightsService;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flights;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.repository.FlightsRepository;

@Service
public class FlightsServiceImpl implements FlightsService {

	@Autowired
	private FlightsRepository flightsRepository;

	@Override
	public List<Flights> findAllFlights() {
		return flightsRepository.findAll();
	}

	@Override
	public Flights createFlight(Flights flights) {
		return flightsRepository.save(flights);
	}

	@Override
	public boolean deleteFlight(Long id) {
		if (flightsRepository.existsById(id)) {
			flightsRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Flights updateFlight(Flights flights) {
		return flightsRepository.save(flights);
	}

}
