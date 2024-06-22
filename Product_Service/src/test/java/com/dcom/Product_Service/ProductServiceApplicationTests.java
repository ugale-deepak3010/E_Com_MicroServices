package com.dcom.Product_Service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.dcom.Product_Service.Dto.ProductRequest;
import com.dcom.Product_Service.Repository.ProductRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@DynamicPropertySource // it will dynamically in application.properties
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {

		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
		
		
		System.err.println(mongoDBContainer.getReplicaSetUrl());
	}

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;// class to JSON

	@Test
	void shouldCreateProduct() throws Exception {
		
		ProductRequest productRequest= getProductRequest();
		String productRequestString =  objectMapper.writeValueAsString(productRequest);
		
		mockMvc.perform(MockMvcRequestBuilders
												.post("/api/product")
												.contentType(MediaType.APPLICATION_JSON)
												.content(productRequestString)
												)
								.andExpect(status().isCreated());
	}
	
	
	@Autowired
	ProductRepo productRepo;
	
	@Test
	public void shouldSaveProduct() {
		Assertions.assertEquals(1,productRepo.findAll().size());
	}
	
	
	
	
	
	
	private ProductRequest getProductRequest() {
	
		return ProductRequest.builder()
					.name("Iphone 16")
					.description("Good iphone 16")
					.price(BigDecimal.valueOf(98989))
					.build();
	}

}
