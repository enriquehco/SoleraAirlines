package com.esteban.analitycservice.service;

import java.util.List;

import com.esteban.analitycservice.entity.Analityc;

public interface AnalitycService {

	List<Analityc> getAllAnalitycs();

	List<Analityc> getAnalitycsByUserName(String userName);

	Analityc saveAnalityc(Analityc analityc);

	Analityc getAnalitycById(Long analitycId);

}
