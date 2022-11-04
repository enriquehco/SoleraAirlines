package com.esteban.purchaseservice.service;

import java.util.List;

import com.esteban.purchaseservice.entity.Purchase;
import com.esteban.purchaseservice.models.Flight;

public interface PurchaseService {

	List<Purchase> getAllPurchases();

	Purchase createPurchase(Purchase purchase);

	Purchase getPurchaseById(Long id);

	Boolean purchaseCompleted(String surname);

	Double getPricePerUser(int basePrice, int age, boolean luggage);

	List<Flight> getFlightsByPurchaseId(Long purchaseId);

}
