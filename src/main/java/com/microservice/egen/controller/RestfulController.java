package com.microservice.egen.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.egen.data.model.Item;
import com.microservice.egen.data.model.Order;
import com.microservice.egen.data.model.Payment;
import com.microservice.egen.service.ItemService;
import com.microservice.egen.service.Orderservice;
import com.microservice.egen.service.PaymentService;

@RestController
public class RestfulController {

	@Autowired
	Orderservice orderService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	PaymentService paymentService;

	@GetMapping("/order")
	private List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	// creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/order/{orderid}")
	private Order getorder(@PathVariable("orderid") int orderid) {
		return orderService.getOrderById(orderid);
	}

	// creating a delete mapping that deletes a specified book
	@DeleteMapping("/order/{orderid}")
	private void deleteOrder(@PathVariable("orderid") int orderid) {
		Order order = getorder(orderid);
		for(Item i : order.getItems()) {
			i.setOrder(order);
			itemService.delete(i.getId());
		}
		for(Payment p:order.getPayments()) {
			p.setOrder(order);
			paymentService.delete(p.getId());
		}
		orderService.delete(orderid);
	}

	// creating post mapping that post the book detail in the database
	@PostMapping("/order")
	private int saveOrder(@RequestBody Order order) {
		
		//UUID uuid = UUID.randomUUID();
		
		orderService.saveOrUpdate(order);
		for(Item i : order.getItems()) {
			i.setOrder(order);
			itemService.saveOrUpdate(i);
		}
		for(Payment p:order.getPayments()) {
			p.setOrder(order);
			paymentService.saveOrUpdate(p);
		}
		return order.getId();
	}

	// creating put mapping that updates the book detail
	@PutMapping("/order/{orderid}")
	private Order update(@RequestBody Order order,@PathVariable("orderid") int orderid) {
		
		orderService.saveOrUpdate(order);
		
		for(Item i : order.getItems()) {
			i.setOrder(order);
			itemService.saveOrUpdate(i);
		}
		for(Payment p:order.getPayments()) {
			p.setOrder(order);
			paymentService.saveOrUpdate(p);
		}
		
		return order;
	}

}
