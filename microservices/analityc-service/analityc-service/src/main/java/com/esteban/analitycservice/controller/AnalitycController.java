package com.esteban.analitycservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.analitycservice.entity.Analityc;
import com.esteban.analitycservice.service.impl.AnalitycServiceImpl;

@RestController
@RequestMapping("/analitycs")
public class AnalitycController {

	@Autowired
	private AnalitycServiceImpl analitycServiceImpl;

	@GetMapping
	public ResponseEntity<List<Analityc>> getAllAnalitycs() {

		List<Analityc> analitycs = analitycServiceImpl.getAllAnalitycs();
		if (analitycs.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(analitycs);
	}

	@PostMapping
	public ResponseEntity<Analityc> saveAnalityc(@RequestBody Analityc analityc) {

		Analityc newAnalityc = analitycServiceImpl.saveAnalityc(analityc);
		return ResponseEntity.ok(newAnalityc);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Analityc>> listAnalitycsByUserId(@PathVariable("userId") Long userId) {

		List<Analityc> analitycs = analitycServiceImpl.getAnalitycsByUserId(userId);
		if (analitycs.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(analitycs);
	}
}
