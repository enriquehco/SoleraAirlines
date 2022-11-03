package com.esteban.analitycservice.service;

import java.util.List;

import com.esteban.analitycservice.entity.Analityc;

public interface AnalitycService {

	List<Analityc> getAllAnalitycs();
	
	List<Analityc> getAnalitycsByUserId(Long userId);
	
	Analityc saveAnalityc(Analityc analityc);
	
	Analityc getAnalitycById(Long analitycId);
	
	
}
