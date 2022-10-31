package com.grupoRocodromo.soleraAirlines.soleraAirlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl.CitiesServiceImpl;

@RestController
@RequestMapping("/cities")
public class CitiesController {
	
	@Autowired
	private CitiesServiceImpl citiesServiceImpl;
	

}
