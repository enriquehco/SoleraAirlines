package com.grupoRocodromo.soleraAirlines.soleraAirlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl.FlightsServiceImpl;

@RestController
@RequestMapping("/flights")
public class FlightsController {

	@Autowired
	private FlightsServiceImpl flightsServiceImpl;

}
