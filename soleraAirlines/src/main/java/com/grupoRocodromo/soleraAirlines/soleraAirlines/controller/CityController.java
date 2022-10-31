package com.grupoRocodromo.soleraAirlines.soleraAirlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl.CityServiceImpl;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityServiceImpl cityServiceImpl;

}
