package com.microservice.egen.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payment {
	
	@Id
	@Column
	private int id;
	@Column
	private String method;
	@Column
	private String date;
	@Column
	private String confirmationNumber;
	
	public Payment() {}
	
	public Payment(int id, String method, String date, String confirmationNumber) {
		this.id = id;
		this.method = method;
		this.date = date;
		this.confirmationNumber = confirmationNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getConfirmationNumber() {
		return confirmationNumber;
	}
	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}


}
