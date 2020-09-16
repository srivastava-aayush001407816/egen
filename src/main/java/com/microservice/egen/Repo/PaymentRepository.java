package com.microservice.egen.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.egen.data.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment,Integer>{

	//List<Payment> findByOrder_id(int orderid);
}
