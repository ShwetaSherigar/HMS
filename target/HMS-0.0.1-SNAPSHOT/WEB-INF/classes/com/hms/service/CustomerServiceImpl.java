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
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	public int createCustomer(Customer customer) {
		customer.setName(customer.getName().toUpperCase());
		customer.setAddress(customer.getAddress().toUpperCase());
		customer.setGender(customer.getGender().toUpperCase());
		return customerDao.createCustomer(customer);
	}

	public Customer getCustomer(String gender) {
		return customerDao.getCustomer(gender);
	}

	@Override
	public int getCustomerId(String emailId) {
		return customerDao.getCustomerId(emailId);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public Customer changePassword(Customer customer) {
		return customerDao.changePassword(customer);
	}

}
