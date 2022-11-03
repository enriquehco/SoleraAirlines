package com.esteban.purchaseservice.service;

import java.util.List;

import com.esteban.purchaseservice.entity.Purchase;

public interface PurchaseService {

	List<Purchase> getAllPurchases();

	Purchase createPurchase(Purchase purchase);

	Purchase getPurchaseById(Long id);

	Boolean purchaseCompleted(String surname);

	//Purchase savePurchaseAfterSaleCompleted(Purchase purchase);


}
