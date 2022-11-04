package com.esteban.analitycservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.analitycservice.entity.Analityc;
import com.esteban.analitycservice.repository.AnalitycRepository;
import com.esteban.analitycservice.service.AnalitycService;

@Service
public class AnalitycServiceImpl implements AnalitycService {

	@Autowired
	private AnalitycRepository analitycRepository;

	@Override
	public List<Analityc> getAllAnalitycs() {
		return analitycRepository.findAll();
	}

	@Override
	public List<Analityc> getAnalitycsByUserName(String userName) {
		return analitycRepository.findByUserName(userName);
	}

	@Override
	public Analityc saveAnalityc(Analityc analityc) {
		return analitycRepository.save(analityc);

	}

	@Override
	public Analityc getAnalitycById(Long analitycId) {
		return analitycRepository.findById(analitycId).orElse(null);
	}

}
