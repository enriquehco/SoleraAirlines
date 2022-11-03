package com.esteban.userservice.controller;

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

import com.esteban.userservice.entity.User;
import com.esteban.userservice.models.Flight;
import com.esteban.userservice.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/listUsers")
	public ResponseEntity<List<User>> listAllUsers() {

		List<User> users = userServiceImpl.getAllUsers();

		if (users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {

		User user = userServiceImpl.getUserById(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User newUser = userServiceImpl.createUser(user);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/flights/{userId}")
	public ResponseEntity<List<Flight>> getFlightsByUserId(@PathVariable("userId") Long userId) {

		User user = userServiceImpl.getUserById(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		List<Flight> flights = userServiceImpl.getFlightsByUserId(userId);
		return ResponseEntity.ok(flights);
	}

}
