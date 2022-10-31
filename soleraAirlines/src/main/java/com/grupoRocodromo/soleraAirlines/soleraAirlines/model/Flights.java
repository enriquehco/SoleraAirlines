package com.grupoRocodromo.soleraAirlines.soleraAirlines.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flights {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="dateTime")
	private Date dateTime;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "luggage")
	private boolean luggage;
	
	@Column(name = "company")
	private String company;
	
	@Column(name ="departureCity")
	private Cities departureCity;
	
	@Column(name = "arrivalCity")
	private Cities arrivalCity;
	
	@ManyToOne
	private Cities cities;
	
	@ManyToMany
	private List<Users> users;

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

	public Cities getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(Cities departureCity) {
		this.departureCity = departureCity;
	}

	public Cities getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(Cities arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Cities getCities() {
		return cities;
	}

	public void setCities(Cities cities) {
		this.cities = cities;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	
	

}
