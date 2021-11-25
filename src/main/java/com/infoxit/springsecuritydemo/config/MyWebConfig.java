package com.infoxit.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.infoxit.springsecuritydemo.service.MyUserDetailsService;
import com.infoxit.springsecuritydemo.util.JwtFilter;

@Configuration
@EnableWebSecurity
public class MyWebConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtFilter jwtTokenFilter;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("ADMIN","USER")
		.antMatchers("/autheticate").permitAll()
		.anyRequest()
		.authenticated()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		 return NoOpPasswordEncoder.getInstance();
	 }
	
	
	@Bean
	 public AuthenticationManager authenticationManagerBean() throws Exception {
		 return super.authenticationManagerBean();
	 }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring().antMatchers("/authenticate");
	}
	
}
