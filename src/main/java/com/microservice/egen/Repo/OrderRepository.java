package com.microservice.egen.Repo;

import org.springframework.data.repository.CrudRepository;

import com.microservice.egen.data.model.Order;

public interface OrderRepository extends CrudRepository<Order,Integer>{
	

}
