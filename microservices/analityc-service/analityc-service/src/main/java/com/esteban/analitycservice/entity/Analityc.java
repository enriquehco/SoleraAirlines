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

	private Date logDate;
	private String typeOfLog;
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getTypeOfLog() {
		return typeOfLog;
	}

	public void setTypeOfLog(String typeOfLog) {
		this.typeOfLog = typeOfLog;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
