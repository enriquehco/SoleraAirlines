package com.grupoRocodromo.soleraAirlines.soleraAirlines.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

	public Flight() {

	}

	public Flight(Long id, Date dateTime, int duration, boolean luggage, String company, int price,
			String departureCity, String layoverCity, String arrivalCity) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.duration = duration;
		this.luggage = luggage;
		this.company = company;
		this.price = price;
		this.departureCity = departureCity;
		this.layoverCity = layoverCity;
		this.arrivalCity = arrivalCity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "dateTime")
	private Date dateTime;

	@Column(name = "duration")
	private int duration;

	@Column(name = "luggage")
	private boolean luggage;

	@Column(name = "company")
	private String company;

	@Column(name = "price")
	private int price;

	@Column(name = "departureCity")
	private String departureCity;

	@Column(name = "layoverCity")
	private String layoverCity;

	@Column(name = "arrivalCity")
	private String arrivalCity;

	/*
	 * @ManyToMany private City cities;
	 *
	 * @ManyToMany private List<User> users;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isLuggage() {
		return luggage;
	}

	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getLayoverCities() {
		return layoverCity;
	}

	public void setLayoverCities(String layoverCities) {
		this.layoverCity = layoverCities;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

//	public City getCities() {
//		return cities;
//	}
//
//	public void setCities(City cities) {
//		this.cities = cities;
//	}
//
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

}
