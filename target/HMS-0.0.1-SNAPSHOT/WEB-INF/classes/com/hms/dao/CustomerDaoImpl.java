package com.hms.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.entity.Customer;
import com.hms.entity.Room;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	public int createCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		return customer.getCustomerId();
		// System.out.println("customer "+customer.getName()+" stored in DB");
	}

	public Customer getCustomer(String emailId) {
		Criteria cr = getSession().createCriteria(Customer.class);
		cr.add(Restrictions.eq("emailId", emailId));
		Customer customer = (Customer) cr.uniqueResult();
		return customer;
	}

	public Customer getCustomerById(int customerId) {
		Criteria cr = getSession().createCriteria(Customer.class);
		cr.add(Restrictions.eq("customerId", customerId));
		Customer customer = (Customer) cr.uniqueResult();
		return customer;
	}

	@Override
	public int getCustomerId(String emailId) {
		Criteria cr = getSession().createCriteria(Customer.class);
		cr.add(Restrictions.eq("emailId", emailId));
		Customer customer = (Customer) cr.uniqueResult();
		return customer.getCustomerId();
	}

	public Customer changePassword(Customer customer) {
		String hql = "update Customer set password= :password where customerId= :customerId";
		Query query = getSession().createQuery(hql);
		query.setParameter("password", customer.getPassword());
		query.setParameter("customerId", customer.getCustomerId());
		query.executeUpdate();
		return customer;
	}

}
