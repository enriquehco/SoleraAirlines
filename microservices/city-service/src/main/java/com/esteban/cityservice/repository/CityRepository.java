package com.esteban.cityservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esteban.cityservice.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
//	List<City> findByFlightId(Long flightId);

}
