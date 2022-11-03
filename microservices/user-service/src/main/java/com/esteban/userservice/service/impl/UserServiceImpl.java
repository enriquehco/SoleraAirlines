package com.esteban.userservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esteban.userservice.entity.User;
import com.esteban.userservice.models.Analityc;
import com.esteban.userservice.models.Flight;
import com.esteban.userservice.repository.UserRepository;
import com.esteban.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	public List<Flight> getFlightsByUserId(Long userId) {

		List<Flight> flights = restTemplate.getForObject("http://localhost:8082/flights/user/" + userId, List.class);
		return flights;
	}

	public List<Analityc> getAnalitycsByUserName(String userName) {

		List<Analityc> analitycs = restTemplate.getForObject("http://localhost:8085/analitycs/user/" + userName,
				List.class);
		return analitycs;

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User getUserByName(String userName) {
		return userRepository.findByName(userName);
	}

}
