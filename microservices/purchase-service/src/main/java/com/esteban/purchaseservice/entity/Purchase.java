package com.esteban.purchaseservice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Date purchaseDate;
	private Double finalPrice;
	private boolean success;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Double getFinalPrice() {
		return finalPrice;
	}


	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}
