package com.esteban.cityservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.cityservice.entity.City;
import com.esteban.cityservice.service.impl.CityServiceImpl;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityServiceImpl cityServiceImpl;

	@GetMapping
	public ResponseEntity<List<City>> listAllCities() {

		List<City> cities = cityServiceImpl.getAllCities();

		if (cities.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cities);
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable("id") Long id) {

		City city = cityServiceImpl.getCitytById(id);
		if (city == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(city);
	}
	
	@PostMapping
	public ResponseEntity<City> saveCity(@RequestBody City city ){
		
		City newCity = cityServiceImpl.createCity(city);
		return ResponseEntity.ok(newCity);
	}
	
	@GetMapping("/flight/{flightId}")
	public ResponseEntity<List<City>> listCitiesByFlightId(@PathVariable Long id){
		
		List<City> cities = cityServiceImpl.getCitiessByFlightId(id);
		if(cities.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(cities);
		
	}
}
