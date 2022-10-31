package com.grupoRocodromo.soleraAirlines.soleraAirlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Cities;


@Repository
public interface CitiesRepository extends JpaRepository<Cities, Long>{

}
