package com.esteban.purchaseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.purchaseservice.entity.Purchase;
import com.esteban.purchaseservice.models.Flight;
import com.esteban.purchaseservice.service.impl.PurchaseServiceImpl;

@RestController
@RequestMapping("/purchases")
@CrossOrigin("http://localhost:3000")
public class PurchaseController {

	@Autowired
	private PurchaseServiceImpl purchaseServiceImpl;

	@GetMapping("/listPurchases")
	public ResponseEntity<List<Purchase>> listAllPurchases() {
		List<Purchase> purchases = purchaseServiceImpl.getAllPurchases();
		if (purchases.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(purchases);
	}

	@GetMapping("/{purchaseId}")
	public ResponseEntity<Purchase> getPurchase(@PathVariable("purchaseId") Long id) {

		Purchase purchase = purchaseServiceImpl.getPurchaseById(id);
		if (purchase == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(purchase);
	}

	@PostMapping
	public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase) {
		Purchase newPurchase = purchaseServiceImpl.createPurchase(purchase);
		return ResponseEntity.ok(newPurchase);
	}

	@GetMapping("/flights/{purchaseId}")
	public ResponseEntity<List<Flight>> getFlightsByPurchaseId(@PathVariable("purchaseId") Long purchaseId) {

		Purchase purchase = purchaseServiceImpl.getPurchaseById(purchaseId);
		if (purchase == null) {
			return ResponseEntity.notFound().build();
		}

		List<Flight> flights = purchaseServiceImpl.getFlightsByPurchaseId(purchaseId);
		return ResponseEntity.ok(flights);

	}

	@GetMapping("/userPrice/{basePrice}/{age}/{luggage}")
	public ResponseEntity<Double> getFinalPricePerUser(@PathVariable int basePrice, @PathVariable int age,@PathVariable boolean luggage) {

		Double price = purchaseServiceImpl.getPricePerUser(basePrice, age, luggage);
		return ResponseEntity.ok(price);
	}

	@GetMapping("/saleCompleted/{surname}")
	public ResponseEntity<Boolean> getStatusOfSale(@PathVariable("surname") String surname){

		boolean success = purchaseServiceImpl.purchaseCompleted(surname);
		return ResponseEntity.ok(success);
	}

}
