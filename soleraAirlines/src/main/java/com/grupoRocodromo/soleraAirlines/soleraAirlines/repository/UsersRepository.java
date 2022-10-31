package com.grupoRocodromo.soleraAirlines.soleraAirlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.User;


@Repository
public interface UsersRepository extends JpaRepository<User, Long>{

}
