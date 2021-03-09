package com.hms.dao;

import com.hms.entity.Customer;

public interface CustomerDao {
	public int createCustomer(Customer customer);

	public Customer getCustomer(String emailId);

	public int getCustomerId(String emailId);

	public Customer getCustomerById(int customerId);

	public Customer changePassword(Customer customer);

}
