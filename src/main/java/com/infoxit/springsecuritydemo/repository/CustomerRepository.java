package com.infoxit.springsecuritydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infoxit.springsecuritydemo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByUsername(String username);
	
	@Query(value = "select * from customer where username =:username and password =:password", nativeQuery = true)
	public Customer findUserByUserNameAndPassword(String username, String password);
}
