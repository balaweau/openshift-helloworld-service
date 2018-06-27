package com.unisys.microservices.helloworld.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisys.microservices.helloworld.model.Customer;
import com.unisys.microservices.helloworld.model.CustomerType;

@RestController
public class Api {
	

	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	private List<Customer> customers;
	
	public Api() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "12345", "Adam Kowalski", CustomerType.INDIVIDUAL));
		customers.add(new Customer(2, "12346", "Anna Malinowska", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "12347", "Paweł Michalski", CustomerType.INDIVIDUAL));
		customers.add(new Customer(4, "12348", "Karolina Lewandowska", CustomerType.INDIVIDUAL));
	}
	
	@RequestMapping("/customers/pesel/{pesel}")
	public Customer findByPesel(@PathVariable("pesel") String pesel) {
		logger.info(String.format("helloworld.findByPesel(%s)", pesel));
		return customers.stream().filter(it -> it.getPesel().equals(pesel)).findFirst().get();	
	}
	
	@RequestMapping("/customers/size")
	public Integer findCustomerCnt() {
		logger.info(String.format("helloworld.findCustomerCnt:", customers.size()));
		return customers.size();	
	}
	
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("helloworld.findAll()");
		return customers;
	}
	
}
