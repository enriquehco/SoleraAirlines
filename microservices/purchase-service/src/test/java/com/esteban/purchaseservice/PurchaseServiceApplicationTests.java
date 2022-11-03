package com.esteban.purchaseservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esteban.purchaseservice.service.impl.PurchaseServiceImpl;

@SpringBootTest
class PurchaseServiceApplicationTests {
	
	@Autowired
	private PurchaseServiceImpl purchaseServiceImpl ;//= new PurchaseServiceImpl();

	@Test
	void completedPurchase_WhenSurnameIsError_ReturnFalse() {

		String surname = "error";

		boolean result = purchaseServiceImpl.purchaseCompleted(surname);

		assertEquals(result, false);

	}

	@Test
	void completedPurchase_WhenSurnameIsNotError_ReturnTrue() {

		String surname = "hola";

		boolean result = purchaseServiceImpl.purchaseCompleted(surname);

		assertEquals(result, true);

	}

}
