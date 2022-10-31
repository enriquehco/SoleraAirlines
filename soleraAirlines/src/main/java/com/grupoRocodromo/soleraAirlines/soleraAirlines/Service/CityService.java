package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.City;

public interface CityService {

	public static City createCity(String name) {		
		City newCity = new City();
		newCity.setName(name);
		
		return newCity;
	};
	
	List<City> findAllCities();

	City updateCity(City city);

	boolean deleteCity(Long id);


}
