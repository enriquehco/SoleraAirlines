package com.esteban.flightservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.flightservice.entity.Flight;
import com.esteban.flightservice.service.impl.FlightServiceImpl;

@RestController
@RequestMapping("/flights")
@CrossOrigin("http://localhost:3000")
public class FlightController {

	@Autowired
	private FlightServiceImpl flightServiceImpl;

	@GetMapping
	public ResponseEntity<List<Flight>> listAllFlights() {

		List<Flight> flights = flightServiceImpl.getAllFlights();

		if (flights.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(flights);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Flight> getFlight(@PathVariable("id") Long id) {

		Flight flight = flightServiceImpl.getFlightById(id);
		if (flight == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(flight);
	}

	@PostMapping
	public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight) {
		Flight newFlight = flightServiceImpl.createFlight(flight);
		return ResponseEntity.ok(newFlight);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Flight>> listFlightsByUserId(@PathVariable("userId") Long id) {

		List<Flight> flights = flightServiceImpl.getFlightsByUserId(id);
		if (flights.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(flights);
	}

	@GetMapping("/city/{cityId}")
	public ResponseEntity<List<Flight>> listFlightsByCityId(@PathVariable("cityId") Long id) {

		List<Flight> flights = flightServiceImpl.getFlightsByCityId(id);
		if (flights.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(flights);
	}

	@GetMapping("/purchase/{purchaseId}")
	public ResponseEntity<List<Flight>> listFlightsByPurchaseId(@PathVariable("purchaseId") Long id) {

		List<Flight> flights = flightServiceImpl.getFlightsByPurchaseId(id);
		if (flights.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(flights);
	}

	@GetMapping("/pricePerUser/{basePrice}/{age}/{luggage}")
	public ResponseEntity<Double> getPricePerUser(@PathVariable("basePrice")Double basePrice,@PathVariable("age") int age, @PathVariable("luggage") boolean luggage) {

		Double price = flightServiceImpl.setPricePerUser(basePrice, age, luggage);
		return ResponseEntity.ok(price);
	}

}
