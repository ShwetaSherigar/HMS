package com.hms.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hms.dao.CustomerDao;

import com.hms.entity.Customer;

public class CustomerTestCase {

	Customer customer = new Customer();

	@Mock
	CustomerDao customerDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetCustomer() {
		Customer customer1 = new Customer(15, "swasti", 7348989464L, "female", "udupi", "sw@gmail.com", "swastika123");
		
		when(customerDao.getCustomer("sw@gmail.com")).thenReturn(customer1);
		assertEquals("sw@gmail.com",customer1.getEmailId());
		
	}
	@Test
	public void testGetCustomerId() {
		Customer customer1 = new Customer(15, "swasti", 7348989464L, "female", "udupi", "sw@gmail.com", "swastika123");
		when(customerDao.getCustomerById(15)).thenReturn(customer1);
		assertEquals(15, customer1.getCustomerId());
		
			}
	

}
