package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Customer;



@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject 
	@Autowired
	private SessionFactory sessionFactory;
	
	
		@Override

	public List<Customer> getCustomers() {
		// create session
		Session currentSession = sessionFactory.getCurrentSession();

		// query
		Query<Customer> theQuery = currentSession.createQuery("from Customer ", Customer.class);
		
		// execute query 
		List<Customer> customers = theQuery.getResultList();
		

		// return the results
		return customers;
	}
		
	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current session
		Session currentSession = sessionFactory.getCurrentSession();

		
		
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int thecode) {

		// get the current  session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, thecode);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int thecode) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where code=:customerCode");
		theQuery.setParameter("customerCode", thecode);

		theQuery.executeUpdate();
	}

}
