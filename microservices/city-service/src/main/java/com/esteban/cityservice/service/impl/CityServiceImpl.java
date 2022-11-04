package com.esteban.cityservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esteban.cityservice.entity.City;
import com.esteban.cityservice.model.Flight;
import com.esteban.cityservice.repository.CityRepository;
import com.esteban.cityservice.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<Flight> getFlightsByCityId(Long cityId) {
		List<Flight> flights = restTemplate.getForObject("http://localhost:8082/flights/city/" + cityId, List.class);
		return flights;
	}

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public City createCity(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City getCitytById(Long id) {
		return cityRepository.findById(id).orElse(null);
	}

}
