package com.infoxit.springsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.springsecuritydemo.service.MyUserDetailsService;
import com.infoxit.springsecuritydemo.util.JwtTokenUtil;
import com.infoxit.springsecuritydemo.util.LoginRequest;

@RestController

public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody LoginRequest request) throws Exception {
		
	
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
			System.out.println("authentication sucess");
		}catch(AuthenticationException e) {
			System.out.println("authentication failure");
			
			return ResponseEntity.ok("Invalid username or password");
		}
		
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getUsername());
		
		final String jwtToken = jwtTokenUtil.generateToken(userDetails);
		
		
		
		return ResponseEntity.ok("JWT Token: "+ jwtToken);
	}
}
