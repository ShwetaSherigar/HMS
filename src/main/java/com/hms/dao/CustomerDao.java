package com.hms.dao;

import com.hms.entity.Customer;

public interface CustomerDao 
{
	public void createCustomer(Customer customer) ;
	public Customer getCustomer(String emailId);

}
