package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		Date now = new Date(); 
		theCustomer.setRegistrationDate(now);

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int thecode) {

		return customerDAO.getCustomer(thecode);
	}

	@Override
	@Transactional
	public void deleteCustomer(int thecode) {

		customerDAO.deleteCustomer(thecode);
	}
}
