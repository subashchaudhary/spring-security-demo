package com.infoxit.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	//public accessible 
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	//accessible to the user role admin and user
	@GetMapping("/user")
	public String user() {
		
		return "hello this is user";
	}
	
	
	//access to only admin
	@GetMapping("/admin")
	public String admin() {
		return "hello this is admi";
	}
	
	@GetMapping("/error")
	public String error() {
		return "Oops, Something Went Wrong !!!";
	}
}

