package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.User;

public interface UserService {
	
	List<User> findAll();
	
	User createUser(User users);
	
	boolean deleteUser(Long id);
	
	User updateUser(User users);
	
	

}
