package com.grupoRocodromo.soleraAirlines.soleraAirlines.cityServiceImplTest;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl.CityServiceImpl;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.City;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityServiceImplTests {

	@Autowired
	private CityServiceImpl citiesServiceImpl;

	/*
	 * @Autowired private TestEntityManager entitTestEntityManager;
	 */

	@Test
	public void findAllCities_ReturnAllCities() {
		int expectedCities = 2;
		assertEquals(expectedCities, citiesServiceImpl.findAllCities().size());
	}

	@Test
	public void findById_ReturnTheCityOfTheId() {

		Optional<City> city = citiesServiceImpl.findById((long) 2);
		assertEquals((long) 2, (long) city.get().getId());
	}

}
