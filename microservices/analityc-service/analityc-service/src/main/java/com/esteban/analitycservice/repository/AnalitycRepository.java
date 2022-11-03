package com.esteban.analitycservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esteban.analitycservice.entity.Analityc;


@Repository
public interface AnalitycRepository extends JpaRepository<Analityc, Long> {
	
	List<Analityc> findByUserId(Long userId);

}
