package com.esteban.flightservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.esteban.flightservice.service.impl.FlightServiceImpl;

@SpringBootTest
class FlightServiceApplicationTests {

	Double basePrice;
	int age;
	boolean luggage = true;
	private FlightServiceImpl flightServiceImpl = new FlightServiceImpl();
//	private FlightRespository flightRespository flightServiceImpl

	/*
	 * @BeforeEach void setUp() { // flightRespository =
	 * Mockito.mock(FlightRespository.class); flightServiceImpl = new
	 * FlightServiceImpl(); }
	 */

	// private FlightServiceImpl flightServiceImpl = new FlightServiceImpl();

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

	/*
	 * @Test void getFlightsByUserId_ShouldReturnAllFlightsOfThisUserId() {
	 *
	 * int expected = 1; int result = flightServiceImpl.getFlightsByUserId((long)
	 * 3).size();
	 *
	 * assertEquals(expected, result);
	 *
	 * }
	 */

}
