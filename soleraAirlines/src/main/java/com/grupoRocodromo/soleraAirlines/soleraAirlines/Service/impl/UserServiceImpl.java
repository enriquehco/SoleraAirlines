package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.UserService;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.User;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	 private UserRepository userRepository;
	
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User users) {
		return userRepository.save(users);
	}

	@Override
	public boolean deleteUser(Long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User updateUser(User users) {
		return userRepository.save(users);
	}

}
