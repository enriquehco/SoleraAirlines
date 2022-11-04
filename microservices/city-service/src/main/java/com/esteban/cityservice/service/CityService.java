package com.esteban.cityservice.service;

import java.util.List;

import com.esteban.cityservice.entity.City;
import com.esteban.cityservice.model.Flight;

public interface CityService {

	List<City> getAllCities();

	City createCity(City city);

	City getCitytById(Long id);

	List<Flight> getFlightsByCityId(Long cityId);

}
