package com.grupoRocodromo.soleraAirlines.soleraAirlines.citiesServiceImplTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl.CitiesServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CitiesServiceImplTests {

	@Autowired
	private CitiesServiceImpl citiesServiceImpl;

	@Test
	public void findAllCities_ReturnAllCities() {

		int expectedCities = 0;

		assertEquals(expectedCities, citiesServiceImpl.findAllCities().size());

	}

}
