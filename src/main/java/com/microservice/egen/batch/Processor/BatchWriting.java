package com.microservice.egen.batch.Processor;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.egen.data.model.Item;
import com.microservice.egen.service.ItemService;
import com.microservice.egen.service.Orderservice;
import com.microservice.egen.service.PaymentService;

@Component
public class BatchWriting implements ItemWriter<Item>{
	
	@Autowired
	Orderservice orderService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	PaymentService paymentService;
	
	
	@Override
	public void write(List<? extends Item> items) throws Exception {
		
		System.out.println("Data saved for order: "+items);
		
		for(Item i:items)
			itemService.saveOrUpdate(i);
		
	}

}
