package com.esteban.userservice.service;

import java.util.List;

import com.esteban.userservice.entity.User;
import com.esteban.userservice.models.Analityc;
import com.esteban.userservice.models.Flight;

public interface UserService {

	List<User> getAllUsers();

	User createUser(User user);

	User getUserById(Long id);

	User getUserByName(String userName);

	List<Flight> getFlightsByUserId(Long userId);

	List<Analityc> getAnalitycsByUserName(String userName);
}
