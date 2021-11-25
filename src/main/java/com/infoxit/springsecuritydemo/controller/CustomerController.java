package com.infoxit.springsecuritydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.springsecuritydemo.entity.Customer;
import com.infoxit.springsecuritydemo.service.CustomerService;
import com.infoxit.springsecuritydemo.util.LoginRequest;
import com.infoxit.springsecuritydemo.util.Response;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
//	@Autowired
//	OrderService orderService;
//	
//	@Autowired
//	
//	PaymentService paymentService;
	
	@PostMapping("/register")
	public Response customerRegister(@RequestBody Customer customer) {
		
		Response response = new Response();
		//validate data
		try {
		Customer savedCustomer = customerService.registerCustomer(customer);
			if( savedCustomer != null) {
				response.setData(savedCustomer);
				response.setMessage("User registered success");
				response.setStatus(true);
			}else {
				response.setMessage("User registration failed");
				response.setStatus(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping("/login")
	public Response customerLogin(@RequestBody LoginRequest login) {
		
		Response response = new Response();
		
		try {
			
			boolean res = customerService.customerLogin(login);
			if(res) {
				response.setMessage("Login Success");
				response.setStatus(true);
			}else {
				response.setMessage("Invalid Credentials.");
				response.setStatus(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return response;
	}
	
//	
//	@PostMapping("/order")
//	public Response orderItem(@RequestBody OrderDetails order) {
//		
//		Response response = new Response();
//		OrderDetails orderDetails = null;
//	
//		try {
//			orderDetails = orderService.orderItems(order);
//			if(order != null) {
//				response.setData(orderDetails);
//				response.setMessage("Ordered Successfully");
//				response.setStatus(true);
//			}else {
//				response.setMessage("Could not orderd item");
//				response.setStatus(false);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	 
//		return response;
//	}
//	
//	
//	@GetMapping("/order/{orderBy}")
//	public Response getOrder(@PathVariable("orderBy") Integer customerId) {
//		Response response = new Response();
//		List<OrderDetails> ordersDetails = null;
//		try {
//		
//			ordersDetails = orderService.getAllOrderDetails(customerId);
//			if(ordersDetails.size() > 0) {
//				response.setData(ordersDetails);
//				response.setMessage("Found Data");
//				response.setStatus(true);
//			}else {
//				response.setMessage("No Data Found");
//				response.setStatus(false);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}
//	
//	@PostMapping("/payment")
//	public Response payMent(@RequestBody Payment payment) {
//		Response response = new Response();
//	 
//		try {
//			boolean res = paymentService.payment(payment);
//			if(res) {
//				response.setMessage("Payment Success");
//				response.setStatus(true);
//			}else {
//				response.setMessage("Payment Failure");
//				response.setStatus(false);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			response.setMessage("Something went Wrong");
//		}
//		
//		return response;
//	}
//	
//	
//	@PostMapping("/orderprocessing")
//	public Response orderCheckOut(@RequestParam Integer orderId, Integer paymentId) {
//		
//		Response response = new Response();
//		try {
//			boolean res = orderService.orderProcessing(orderId, paymentId);
//			if(res) {
//				response.setMessage("Your item has been successfuly orderd. it will be delivered your delivery address within 15 bussiness days");
//				response.setStatus(true);
//			}else {
//				response.setMessage("Your order could not be processed");
//				response.setStatus(false);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}
	
	
	
	
}
