package com.esteban.purchaseservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esteban.purchaseservice.entity.Purchase;
import com.esteban.purchaseservice.models.Flight;
import com.esteban.purchaseservice.repository.PurchaseRepository;
import com.esteban.purchaseservice.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Flight> getFlightsByPurchaseId(Long purchaseId) {

		List<Flight> flights = restTemplate.getForObject("http://localhost:8082/flights/purchase/" + purchaseId,
				List.class);
		return flights;
	}

	@Override
	public Double getPricePerUser(int basePrice, int age, boolean luggage) {

		Double pricePerUser = restTemplate.getForObject(
				"http://localhost:8082/flights/pricePerUser/" + basePrice + "/" + age + "/" + luggage, Double.class);
		return pricePerUser;
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase createPurchase(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

	@Override
	public Purchase getPurchaseById(Long id) {
		return purchaseRepository.findById(id).orElse(null);
	}

	@Override
	public Boolean purchaseCompleted(String surname) {
		boolean success = true;

		if (surname.toLowerCase().equals("error")) {
			success = false;
		}

		return success;
	}

}
