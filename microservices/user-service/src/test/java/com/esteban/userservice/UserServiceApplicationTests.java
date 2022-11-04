package com.esteban.userservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esteban.userservice.entity.User;
import com.esteban.userservice.models.Flight;
import com.esteban.userservice.service.impl.UserServiceImpl;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	@Test
	void getFlightsByUserId_WhenIdDoesNotExist_ReturnNull() {

		Long id = 0L;

		List<Flight> result = userServiceImpl.getFlightsByUserId(id);

		assertNull(result);

	}

	@Test
	void getFlightsByUserId_WhenIdExists_ReturnNotNull() {

		Long id = 1L;

		List<Flight> result = userServiceImpl.getFlightsByUserId(id);

		assertNotNull(result);

	}

	@Test
	void getUserById_WhenIdDoesNotExist_ReturnNull() {

		Long id = 5L;

		User result = userServiceImpl.getUserById(id);

		assertNull(result);

	}

	@Test
	void getUserById_WhenIdExists_ReturnNotNull() {

		Long id = 1L;

		User result = userServiceImpl.getUserById(id);

		assertNotNull(result);

	}
}
