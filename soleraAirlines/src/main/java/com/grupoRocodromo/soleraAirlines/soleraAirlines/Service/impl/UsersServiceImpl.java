package com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.Service.UsersService;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Users;
import com.grupoRocodromo.soleraAirlines.soleraAirlines.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

	 @Autowired
	 private UsersRepository usersrepository;
	
	
	@Override
	public List<Users> findAll() {
		return usersrepository.findAll();
	}

	@Override
	public Users createUser(Users users) {
		return usersrepository.save(users);
	}

	@Override
	public boolean deleteUser(Long id) {
		if(usersrepository.existsById(id)) {
			usersrepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Users updateUser(Users users) {
		return usersrepository.save(users);
	}

}
