package com.microservice.egen.data.model;

import java.util.Date;

public class Payment {
	
	private int id;
	private String method;
	private Date date;
	private String confirmationNumber;
	
	public Payment() {}
	
	public Payment(int id, String method, Date date, String confirmationNumber) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getConfirmationNumber() {
		return confirmationNumber;
	}
	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}


}
