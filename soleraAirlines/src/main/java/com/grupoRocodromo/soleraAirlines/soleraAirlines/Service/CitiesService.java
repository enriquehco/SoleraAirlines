package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Cities;

public interface CitiesService {
	
	
	List<Cities> findAllCities();
	
	Cities updateCity(Cities city);
	
	boolean deleteCity(Long id);
	
	Cities createCity(Cities city);
	

}
