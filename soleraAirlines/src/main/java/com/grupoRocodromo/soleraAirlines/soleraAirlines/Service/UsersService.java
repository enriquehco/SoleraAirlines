package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service;

import java.util.List;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Users;

public interface UsersService {
	
	List<Users> findAll();
	
	Users createUser(Users users);
	
	boolean deleteUser(Long id);
	
	Users updateUser(Users users);
	
	

}
