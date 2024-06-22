package com.dcom.Order_Service.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemDTO {
	
	
	private long id;
	private String skuCode;
	private BigDecimal price;
	private int quantity;

}
