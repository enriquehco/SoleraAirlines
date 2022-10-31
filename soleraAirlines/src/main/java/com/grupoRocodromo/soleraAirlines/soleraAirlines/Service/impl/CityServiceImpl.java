package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.CityService;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.City;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<City> findAllCities() {

		return cityRepository.findAll();
	}

	@Override
	public City updateCity(City city) {

		return cityRepository.save(city);
	}

	@Override
	public boolean deleteCity(Long id) {
		if (cityRepository.existsById(id)) {
			cityRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public City createCity(City city) {

		return cityRepository.save(city);
	}

	@Override
	public Optional<City> findById(Long id) {
		
		return cityRepository.findById(id);
	}

	
}
