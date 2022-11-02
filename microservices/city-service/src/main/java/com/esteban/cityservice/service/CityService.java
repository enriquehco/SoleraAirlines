package com.esteban.cityservice.service;

import java.util.List;

import com.esteban.cityservice.entity.City;


public interface CityService {
	
	List<City> getAllCities();

	City createCity(City city);

	City getCitytById(Long id);
	
	List<City> getCitiessByFlightId(Long flightId);

}
