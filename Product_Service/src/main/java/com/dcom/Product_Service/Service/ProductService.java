package com.dcom.Product_Service.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcom.Product_Service.Dto.ProductRequest;
import com.dcom.Product_Service.Dto.ProductResponse;
import com.dcom.Product_Service.Model.Product;
import com.dcom.Product_Service.Repository.ProductRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

	
	private final ProductRepo productRepo;

	public void createProduct(ProductRequest productRequest) {

		Product product = Product.builder()
									.name(productRequest.getName())
									.description(productRequest.getDescription())
									.price(productRequest.getPrice())
									.build();

		productRepo.save(product);

		log.info(" Product is saved ID= {} ", product.getId());
			
	}

	public List<ProductResponse> getAllProducts() {

		return productRepo.findAll().stream().map(product -> productToProductResponse(product)).toList();
	}

	
	
	
	
	private ProductResponse productToProductResponse(Product product) {

		return ProductResponse.builder()
						.id(product.getId())
						.description(product.getDescription())
						.name(product.getName())
						.price(product.getPrice())
						.build();
	}
}
