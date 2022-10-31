package com.grupoRocodromo.soleraAirlines.soleraAirlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupoRocodromo.soleraAirlines.soleraAirlines.model.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
