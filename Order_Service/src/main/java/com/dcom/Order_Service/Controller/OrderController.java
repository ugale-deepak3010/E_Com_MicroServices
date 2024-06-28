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
	@ResponseStatus(code = HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) throws IllegalAccessException {

		boolean b= orderService.placeOrder(orderRequest);

		return b?"Order placed successfully!":"Failed to order!";
	}
	
	
	public String deepFallBackMethod( OrderRequest orderRequest, RuntimeException runtimeExceptions) {
		
		
		return "Ooops! something went wrong with inventory service. please order after sometime!";
	}

}
