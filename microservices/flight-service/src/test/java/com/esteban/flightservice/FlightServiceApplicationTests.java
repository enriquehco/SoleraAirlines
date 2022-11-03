package com.esteban.flightservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.esteban.flightservice.service.impl.FlightServiceImpl;

@SpringBootTest
class FlightServiceApplicationTests {

	Double basePrice;
	int age;
	boolean luggage = true;

	private FlightServiceImpl flightServiceImpl = new FlightServiceImpl();

	@Test
	void setPricePerUser_WhenAgeLessThan2_ReturnZero() {

		Double expected = 0.0;
		basePrice = 10.2;
		age = 1;
		luggage = false;

		Double result = flightServiceImpl.setPricePerUser(basePrice, age, luggage);

		assertEquals(expected, result);
	}

	@Test
	void setPricePerUser_WhenAgeBetweenTwoAndNine_ReturnPriceWithDiscount0_5() {

		Double expected = 5.0;
		basePrice = 10.0;
		age = 3;
		luggage = false;

		Double result = flightServiceImpl.setPricePerUser(basePrice, age, luggage);

		assertEquals(expected, result);
	}

	@Test
	void setPricePerUser_WhenAgeMoreThanNine_ReturnPriceWithDiscount1() {

		Double expected = 10.0;
		basePrice = 10.0;
		age = 18;
		luggage = false;

		Double result = flightServiceImpl.setPricePerUser(basePrice, age, luggage);

		assertEquals(expected, result);
	}

	@Test
	void setPriceUser_WhenAgeLessThanTwoAndLuggageTrue_ReturnDiscount0_2() {

		Double expected = 2.0;
		basePrice = 10.0;
		age = 1;
		luggage = true;
		Double result = flightServiceImpl.setPricePerUser(basePrice, age, luggage);

		assertEquals(expected, result);

	}

}
