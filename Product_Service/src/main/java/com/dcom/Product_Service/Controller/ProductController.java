package com.dcom.Product_Service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcom.Product_Service.Dto.ProductRequest;
import com.dcom.Product_Service.Dto.ProductResponse;
import com.dcom.Product_Service.Service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public String postProductRequest(@RequestBody ProductRequest productRequest) {

		productService.createProduct(productRequest);
		return "Created!";
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		
		return productService.getAllProducts();
	}

}
