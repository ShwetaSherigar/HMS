package com.hms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao
{
	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession()
	{
		return (Session)sessionFactory.getCurrentSession();
	}
	
	
	public void createCustomer(Customer customer) 
	{
		getSession().saveOrUpdate(customer);
		System.out.println("customer "+customer.getName()+" stored in DB");
	}
}
