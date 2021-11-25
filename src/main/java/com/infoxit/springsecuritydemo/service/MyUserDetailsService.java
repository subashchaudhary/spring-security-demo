package com.infoxit.springsecuritydemo.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infoxit.springsecuritydemo.entity.Customer;
import com.infoxit.springsecuritydemo.repository.CustomerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{


	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		Customer customer = customerRepo.findByUsername(username).get();
		
		if(customer != null) {
			String password = customer.getPassword();
			if(password != null) {
				return new User(username, password, Arrays.asList(new SimpleGrantedAuthority("USER")));
			} 
		}
		
		return new User("","",Arrays.asList(new SimpleGrantedAuthority("")));
		 
	}

	
	
}
