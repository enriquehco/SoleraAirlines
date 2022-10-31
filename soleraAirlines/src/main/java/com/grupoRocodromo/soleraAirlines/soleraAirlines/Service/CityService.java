package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.City;

public interface CityService {

	City createCity(City city);
	
	List<City> findAllCities();

	City updateCity(City city);

	boolean deleteCity(Long id);


}
