package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;
import java.util.Optional;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.City;

public interface CityService {

	List<City> findAllCities();

	Optional<City> findById(Long id);

	City updateCity(City city);

	boolean deleteCity(Long id);

	City createCity(City city);

}
