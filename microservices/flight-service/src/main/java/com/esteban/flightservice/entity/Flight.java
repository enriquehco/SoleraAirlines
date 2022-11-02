package com.esteban.flightservice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String company;
	private boolean cabinLuggage;
	private int basePrice;
	private String departureCity;
	private int duration;
	private Date dateTime;
	private String layoverCity;
	private String arrivalCity;
	private Long userId;
	private Long cityId;
	private Long purchaseId;


	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean getcabinLuggage() {
		return cabinLuggage;
	}

	public void setcabinLuggage(boolean luggage) {
		this.cabinLuggage = luggage;
	}

	public int getbasePrice() {
		return basePrice;
	}

	public void setbasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getLayoverCity() {
		return layoverCity;
	}

	public void setLayoverCity(String layoverCity) {
		this.layoverCity = layoverCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

}
