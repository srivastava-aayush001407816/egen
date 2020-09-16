package com.microservice.egen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.egen.Repo.PaymentRepository;
import com.microservice.egen.data.model.Payment;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;
	
	public List<Payment> getAllPayments()   
	{  
		List<Payment> payment = new ArrayList<Payment>();  
		paymentRepo.findAll().forEach(payment1 -> payment.add(payment1));  
		return payment;  
	} 
	
//	public List<Payment> getAllPaymentsOrderid(int id)   
//	{   
//		return paymentRepo.findByOrder_id(id);  
//	}
	
	//getting a specific record by using the method findById() of CrudRepository  
	public Payment getPaymentById(int id)   
	{  
		return paymentRepo.findById(id).get();  
	}
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Payment payment)   
	{  
		paymentRepo.save(payment); 
	} 
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		paymentRepo.deleteById(id);  
	} 
	
	//updating a record  
	public void update(Payment payment, int payid)   
	{  
		paymentRepo.save(payment);  
	}

}
