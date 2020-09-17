package com.microservice.egen.batch.Processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.microservice.egen.data.model.Item;
import com.microservice.egen.data.model.Order;

@Component
public class Processor implements ItemProcessor<Item,Item>{
	
//	public Order order;
//	
//	Processor(Order order){
//		this.order=order;
//	}
	

	@Override
	public Item process(Item item) throws Exception {
		//item.setOrder(order);
		return item;
	}

	
}
