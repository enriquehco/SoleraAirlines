package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.City;

public interface CitiesService {
	
	
	List<City> findAllCities();
	
	City updateCity(City city);
	
	boolean deleteCity(Long id);
	
	City createCity(City city);
	

}
