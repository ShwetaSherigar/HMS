package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Customer;
import com.hms.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerService customerService;
	@PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) 
	{
        customerService.createCustomer(customer);
        return customer;
	}
	
}
