package com.esteban.flightservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.esteban.flightservice.repository.FlightRespository;
import com.esteban.flightservice.service.impl.FlightServiceImpl;
import com.esteban.flightservice.*;
import com.esteban.flightservice.entity.Flight;

@ExtendWith(MockitoExtension.class)
class FlightServiceJPATests {

	@InjectMocks
	FlightServiceImpl flightServiceImpl;

	@Mock
	private FlightRespository flightRespository;

	@Test
	void getAllFlights_WhenSearchFlights_ReturnNumberOfFlightsThatAreStoredInDB() {

		List<Flight> list = new ArrayList<Flight>();
		Flight f1 = new Flight();
		Flight f2 = new Flight();
		Flight f3 = new Flight();

		list.add(f1);
		list.add(f2);
		list.add(f3);

		when(flightRespository.findAll()).thenReturn(list);

		List<Flight> flightList = flightServiceImpl.getAllFlights();
		assertEquals(3, flightList.size());

	}

	@Test
	void getFlightsByUserId_WhenPassUserId_ReturnNumberOFFlightsForThisUser() {

		List<Flight> list = new ArrayList<Flight>();

		Flight f1 = new Flight((long)1,(long)2,(long)3);
		Flight f2 = new Flight((long)1,(long)1,(long)2);
		Flight f3 = new Flight((long)1,(long)3,(long)4);
		
		list.add(f1);
		list.add(f2);
		list.add(f3);
		
		when(flightRespository.findByUserId((long)1)).thenReturn(list);
		List<Flight> flightList = flightServiceImpl.getFlightsByUserId((long)1);
		assertEquals(3, flightList.size());


	}

}
