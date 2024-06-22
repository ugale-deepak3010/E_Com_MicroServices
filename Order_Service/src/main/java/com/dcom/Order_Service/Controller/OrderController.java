package com.dcom.Order_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dcom.Order_Service.DTO.OrderRequest;
import com.dcom.Order_Service.Service.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public String getMethodName() {
		return "Orders!";
	}
	
	@PostMapping
	@ResponseStatus( code = HttpStatus.CREATED) 
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		
		orderService.placeOrder(orderRequest);
		
		return "Order placed successfully!";
	}
	
	
	
}
