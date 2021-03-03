package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Customer;
import com.hms.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	
	@GetMapping("/getCustomer/{emailId:.+}/")
	private ResponseEntity<Customer> getCustomer(@PathVariable("emailId") String emailId)
	{
		Customer customer=customerService.getCustomer(emailId);
		//System.out.println(customer.getCustomerId()+" "+customer.getEmailId());
		if(customer==null) 
		{
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
}
