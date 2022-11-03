package com.esteban.analitycservice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Analityc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date logInDate;
	private Date logOutDate;
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLogInDate() {
		return logInDate;
	}

	public void setLogInDate(Date logInDate) {
		this.logInDate = logInDate;
	}

	public Date getLogOutDate() {
		return logOutDate;
	}

	public void setLogOutDate(Date logOutDate) {
		this.logOutDate = logOutDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
