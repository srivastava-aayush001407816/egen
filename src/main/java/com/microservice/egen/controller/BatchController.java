package com.microservice.egen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BatchController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@Autowired
	Orderservice orderService;
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/load")
	public BatchStatus load(@RequestBody Order order) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{

		orderService.saveOrUpdate(order);
		for(Payment p:order.getPayments()) {
			p.setOrder(order);
			paymentService.saveOrUpdate(p);
		}
		Map<String, JobParameter> map = new HashMap<String, JobParameter>();
		map.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameter = new JobParameters(map);
		JobExecution je = jobLauncher.run(job, jobParameter);
		System.out.println("Job status "+je.getStatus());
		System.out.println("Batch is running.. ");
		while(je.isRunning())
			System.out.println("...");
		return je.getStatus();
	}
	
	@PutMapping("/update/{orderid}")
	private Order update(@RequestBody Order order,@PathVariable("orderid") int orderid) {
		
		
		Order fetchOrder = orderService.getOrderById(orderid);
		fetchOrder.setStatus(order.getStatus());
		fetchOrder.setCustomer_id(order.getCustomer_id());
		fetchOrder.setSubtotal(order.getSubtotal());
		fetchOrder.setTax(order.getTax());
		fetchOrder.setShipping_charges(order.getShipping_charges());
		fetchOrder.setTotal(order.getTotal());
		
		
		for(Payment i : fetchOrder.getPayments()) {
			for(Payment j:order.getPayments()) {
				if(i.getId()==j.getId()) {
					i.setMethod(j.getMethod());
					i.setDate(j.getDate());
					i.setAmount(j.getAmount());
					i.setConfirmationNumber(j.getConfirmationNumber());
					i.setOrder(order);
					
				}
			}
		}
		fetchOrder.setBilling_addressline1(order.getBilling_addressline1());
		fetchOrder.setBilling_addressline2(order.getBilling_addressline2());
		fetchOrder.setBilling_city(order.getBilling_city());
		fetchOrder.setBilling_zip(order.getBilling_zip());
		fetchOrder.setShipping_addressline1(order.getShipping_addressline1());
		fetchOrder.setShipping_addressline2(order.getShipping_addressline2());
		fetchOrder.setShipping_city(order.getShipping_city());
		fetchOrder.setShipping_state(order.getShipping_state());
		fetchOrder.setShipping_zip(order.getShipping_zip());
		
		orderService.saveOrUpdate(fetchOrder);
		for(Payment p:fetchOrder.getPayments()) {
			p.setOrder(fetchOrder);
			paymentService.saveOrUpdate(p);
		}
		
		return order;
	}

}
