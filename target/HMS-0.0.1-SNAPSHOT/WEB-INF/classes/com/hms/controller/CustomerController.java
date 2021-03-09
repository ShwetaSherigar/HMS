package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Customer;
import com.hms.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/create")
	public int createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);

	}

	@GetMapping("/getCustomer/{emailId:.+}/")
	public ResponseEntity<Customer> getCustomer(@PathVariable("emailId") String emailId) {
		Customer customer = customerService.getCustomer(emailId);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@GetMapping("/getCustomerId/{emailId:.+}/")
	public ResponseEntity<Integer> getCustomerId(@PathVariable("emailId") String emailId) {

		int customerId = customerService.getCustomerId(emailId);
		return new ResponseEntity<Integer>(customerId, HttpStatus.OK);
	}

	@GetMapping("/getCustomerById/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		// System.out.println(customer.getCustomerId()+" "+customer.getEmailId());

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PutMapping("/changePassword")
	private ResponseEntity<Customer> changePassword(@RequestBody Customer customer) {
		Customer customerPasswordAndId = customerService.changePassword(customer);
		// System.out.println(customer.getCustomerId()+" "+customer.getEmailId());

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
