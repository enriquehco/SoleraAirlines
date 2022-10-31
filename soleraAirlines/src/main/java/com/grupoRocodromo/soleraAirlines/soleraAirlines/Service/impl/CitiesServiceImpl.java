package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.CitiesService;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Cities;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.repository.CitiesRepository;

@Service
public class CitiesServiceImpl implements CitiesService {

	@Autowired
	private CitiesRepository citiesRepository;

	@Override
	public List<Cities> findAllCities() {

		return citiesRepository.findAll();
	}

	@Override
	public Cities updateCity(Cities city) {

		return citiesRepository.save(city);
	}

	@Override
	public boolean deleteCity(Long id) {
		if (citiesRepository.existsById(id)) {
			citiesRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Cities createCity(Cities city) {

		return citiesRepository.save(city);
	}

}
