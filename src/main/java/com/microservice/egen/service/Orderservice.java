package com.microservice.egen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.egen.Repo.ItemRepository;
import com.microservice.egen.Repo.OrderRepository;
import com.microservice.egen.data.model.Item;
import com.microservice.egen.data.model.Order;

@Service
public class Orderservice {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	public List<Order> getAllOrders()   
	{  
		List<Order> order = new ArrayList<Order>(); 
		orderRepo.findAll().forEach(order1 -> order.add(order1)); 
		
		
		return order;  
	} 
	
	
	public List<Order> getAllOrdersDisplay()   
	{  
		List<Order> order = new ArrayList<Order>(); 
		orderRepo.findAll().forEach(order1 -> order.add(order1)); 
		for(Order o: order) {
			List<Item> item= itemRepo.findByOrder_id(o.getId());
			for(Item i:item) {
				i.setOrder(null);
			}
			o.setItems(item);
		}
		
		return order;  
	}
	
	//getting a specific record by using the method findById() of CrudRepository  
	public Order getOrderById(int id)   
	{  
		return orderRepo.findById(id).get();  
	}
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Order order)   
	{  
		orderRepo.save(order);  
	} 
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		orderRepo.deleteById(id);  
	} 
	
	//updating a record  
	public void update(Order order, int orderid)   
	{  
		orderRepo.save(order);  
	} 

}
