package com.microservice.egen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.egen.Repo.ItemRepository;
import com.microservice.egen.data.model.Item;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> getAllItems()   
	{  
		List<Item> item = new ArrayList<Item>();  
		itemRepository.findAll().forEach(item1 -> item.add(item1));  
		return item;  
	} 
	
	public List<Item> getAllItemsDisplay(int id)   
	{   
		return itemRepository.findByOrder_id(id);  
	}
	
	//getting a specific record by using the method findById() of CrudRepository  
	public Item getItemById(int id)   
	{  
		return itemRepository.findById(id).get();  
	}
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Item item)   
	{  
		itemRepository.save(item); 
	} 
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		itemRepository.deleteById(id);  
	} 
	
	//updating a record  
	public void update(Item item, int itemid)   
	{  
		itemRepository.save(item);  
	}

}
