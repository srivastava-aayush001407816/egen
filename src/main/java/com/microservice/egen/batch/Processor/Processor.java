package com.microservice.egen.batch.Processor;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.egen.data.model.Item;
import com.microservice.egen.data.model.Order;
import com.microservice.egen.service.Orderservice;

@Component
public class Processor implements ItemProcessor<Item,Item>{
	
	@Autowired
	Orderservice orderService;
	

	@Override
	public Item process(Item item) throws Exception {
		
		List<Order> fetchOrder = orderService.getAllOrders();
		Order order = fetchOrder.get(fetchOrder.size()-1);
		item.setOrder(order);
		return item;
	}

	
}
