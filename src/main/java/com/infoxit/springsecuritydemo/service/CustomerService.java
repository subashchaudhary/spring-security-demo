package com.infoxit.springsecuritydemo.service;

 
import com.infoxit.springsecuritydemo.entity.Customer;
import com.infoxit.springsecuritydemo.util.LoginRequest;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws Exception;
	
	public boolean customerLogin(LoginRequest login) throws Exception;
}
