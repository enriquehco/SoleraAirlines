package com.esteban.flightservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esteban.flightservice.repository.FlightRespository;
import com.esteban.flightservice.service.impl.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
class FlightServiceJPATests {
	
	@InjectMocks
	FlightServiceImpl flightServiceImpl;
	
	@Mock
	private FlightRespository flightRespository;
	
	
	@Test
	void findByUserId_WhenPassUserId_ReturnNumberOfFlights() {
			
	//	List<Flight> list = new ArrayList<Employee>();
		Long userId = (long) 3;
		int result = flightRespository.findByUserId(userId).size();

		int expected = 1;
		
		assertEquals(result, expected );
	}

}
