package com.dcom.Order_Service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
// we don't know Inventory Service business logic
	
	private String skuCode;
	private boolean isInStock;
	private int quantity;
}
