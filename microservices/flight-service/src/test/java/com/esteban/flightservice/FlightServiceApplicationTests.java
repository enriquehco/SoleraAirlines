package com.esteban.flightservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esteban.flightservice.service.impl.FlightServiceImpl;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class FlightServiceApplicationTests {

	Double basePrice;
	int age;
	boolean luggage = true;

	@Autowired
	private FlightServiceImpl flightServiceImpl; //= new FlightServiceImpl();

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

	@Test
	void setPriceUser_WhenAgeBetweenTwoAndNineAndLuggageTrue_ReturnDiscount0_7() {

		Double expected = 7.0;
		basePrice = 10.0;
		age = 5;
		luggage = true;
		Double result = flightServiceImpl.setPricePerUser(basePrice, age, luggage);

		assertEquals(expected, result);

	}

	@Test
	void setPriceUser_WhenAgeMoreThanNineAndLuggageTrue_ReturnDiscount1_2() {

		Double expected = 12.0;
		basePrice = 10.0;
		age = 18;
		luggage = true;
		Double result = flightServiceImpl.setPricePerUser(basePrice, age, luggage);

		assertEquals(expected, result);
	}
}
