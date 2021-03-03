package com.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

import com.hms.dao.CustomerDao;
import com.hms.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerDao customerDao;
	
	
	public void createCustomer(Customer customer) 
	{
		customerDao.createCustomer(customer);
	}
	
	public Customer getCustomer(String gender)
	{
		return customerDao.getCustomer(gender);
	}


}
