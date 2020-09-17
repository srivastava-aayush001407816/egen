package com.microservice.egen.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String status;
	@Column
	private int customer_id;
	@Column
	private float subtotal;
	@Column
	private float tax;
	@Column
	private float shipping_charges;
	@Column
	private float total;
	
	@Column
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private List<Item> items;
	@Column
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private List<Payment> payments;
	
	@Column
	private String billing_addressline1;
	@Column
	private String billing_addressline2;
	@Column
	private String billing_city;
	@Column
	private String billing_state;
	@Column
	private String billing_zip;

	
	@Column
	private String shipping_addressline1;
	@Column
	private String shipping_addressline2;
	@Column
	private String shipping_city;
	@Column
	private String shipping_state;
	@Column
	private String shipping_zip;
	
	public Order() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getShipping_charges() {
		return shipping_charges;
	}
	public void setShipping_charges(float shipping_charges) {
		this.shipping_charges = shipping_charges;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getBilling_addressline1() {
		return billing_addressline1;
	}
	public void setBilling_addressline1(String billing_addressline1) {
		this.billing_addressline1 = billing_addressline1;
	}
	public String getBilling_addressline2() {
		return billing_addressline2;
	}
	public void setBilling_addressline2(String billing_addressline2) {
		this.billing_addressline2 = billing_addressline2;
	}
	public String getBilling_city() {
		return billing_city;
	}
	public void setBilling_city(String billing_city) {
		this.billing_city = billing_city;
	}
	public String getBilling_state() {
		return billing_state;
	}
	public void setBilling_state(String billing_state) {
		this.billing_state = billing_state;
	}
	public String getBilling_zip() {
		return billing_zip;
	}
	public void setBilling_zip(String billing_zip) {
		this.billing_zip = billing_zip;
	}
	public String getShipping_addressline1() {
		return shipping_addressline1;
	}
	public void setShipping_addressline1(String shipping_addressline1) {
		this.shipping_addressline1 = shipping_addressline1;
	}
	public String getShipping_addressline2() {
		return shipping_addressline2;
	}
	public void setShipping_addressline2(String shipping_addressline2) {
		this.shipping_addressline2 = shipping_addressline2;
	}
	public String getShipping_city() {
		return shipping_city;
	}
	public void setShipping_city(String shipping_city) {
		this.shipping_city = shipping_city;
	}
	public String getShipping_state() {
		return shipping_state;
	}
	public void setShipping_state(String shipping_state) {
		this.shipping_state = shipping_state;
	}
	public String getShipping_zip() {
		return shipping_zip;
	}
	public void setShipping_zip(String shipping_zip) {
		this.shipping_zip = shipping_zip;
	}

	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}



	@Override
	public String toString() {
		return "Order [status=" + status + ", customer_id=" + customer_id + ", subtotal=" + subtotal + ", tax=" + tax
				+ ", shipping_charges=" + shipping_charges + ", total=" + total + ", items=" + items + ", payments="
				+ payments + ", billing_addressline1=" + billing_addressline1 + ", billing_addressline2="
				+ billing_addressline2 + ", billing_city=" + billing_city + ", billing_state=" + billing_state
				+ ", billing_zip=" + billing_zip + ", shipping_addressline1=" + shipping_addressline1
				+ ", shipping_addressline2=" + shipping_addressline2 + ", shipping_city=" + shipping_city
				+ ", shipping_state=" + shipping_state + ", shipping_zip=" + shipping_zip + "]";
	}
	
	

}
