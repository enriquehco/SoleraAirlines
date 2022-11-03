package com.esteban.cityservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esteban.cityservice.entity.City;
import com.esteban.cityservice.model.Flight;
import com.esteban.cityservice.service.impl.CityServiceImpl;

@SpringBootTest
class CityServiceApplicationTests {

	@Autowired
	private CityServiceImpl cityServiceImpl; // = new CityServiceImpl();

	@Test
	void getFlightsByCityId_WhenIdDoesNotExist_ReturnNull() {

		Long id = 0L;

		List<Flight> result = cityServiceImpl.getFlightsByCityId(id);

		assertNull(result);
	}

	@Test
	void getCitytById_WhenIdDoesNotExist_ReturnNull() {

		Long id = 1L;

		City result = cityServiceImpl.getCitytById(id);

		assertNull(result);

	}

	@Test
	void getCitytById_WhenIdExists_ReturnNotNull() {

		Long id = 1L;

		City result = cityServiceImpl.getCitytById(id);

		assertNotNull(result);

	}
}
