package com.microservice.egen.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private int qty;
	
	@ManyToOne
	private Order order;
	
	public Item() {}
	
	public Item(int id, String name, int qty) {
		this.id = id;
		this.name = name;
		this.qty = qty;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

//	public Order getOrder() {
//		return order;
//	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
