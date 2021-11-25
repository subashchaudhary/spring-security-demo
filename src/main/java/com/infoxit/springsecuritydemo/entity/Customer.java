package com.infoxit.springsecuritydemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String customerName;
	
	private String address;
	
	private String shippingAddress;
	
	private String phone;
	
	private String email;
	
	private String username;
	
	private String password;
	
	@OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cId", referencedColumnName = "id")
	private List<Item> items;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Customer(Integer id, String customerName, String address, String shippingAddress, String phone, String email,
			String username, String password, List<Item> items) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.address = address;
		this.shippingAddress = shippingAddress;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.items = items;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
