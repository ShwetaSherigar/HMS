package com.hms.service;

import com.hms.entity.Customer;

public interface CustomerService {

	public int createCustomer(Customer customer);

	public Customer getCustomer(String emailId);

	public int getCustomerId(String emailId);

	public Customer getCustomerById(int customerId);

	public Customer changePassword(Customer customer);
}
