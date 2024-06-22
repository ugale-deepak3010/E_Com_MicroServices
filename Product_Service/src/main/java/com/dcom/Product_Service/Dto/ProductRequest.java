package com.dcom.Product_Service.Dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // for me it's new
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequest {

	private String name;
	private String description;
	private BigDecimal price;
}
