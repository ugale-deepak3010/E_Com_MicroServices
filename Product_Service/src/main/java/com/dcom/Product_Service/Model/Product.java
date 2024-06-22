package com.dcom.Product_Service.Model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder	// for me it's new
@Document("product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;

}
