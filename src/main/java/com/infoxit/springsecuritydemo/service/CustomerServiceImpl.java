package com.infoxit.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoxit.springsecuritydemo.entity.Customer;
import com.infoxit.springsecuritydemo.repository.CustomerRepository;
import com.infoxit.springsecuritydemo.util.LoginRequest;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Customer registerCustomer(Customer customer) throws Exception {
		
		return customerRepo.save(customer);
		
	}

	@Override
	public boolean customerLogin(LoginRequest login) throws Exception {
		 
		Customer customer = null;
		if(login.getUsername() != null && login.getPassword() != null) {
			customer =  customerRepo.findUserByUserNameAndPassword(login.getUsername(), login.getPassword());
		}
		
		if(customer != null) return true;
		
		return false;
	}

	
	
}
