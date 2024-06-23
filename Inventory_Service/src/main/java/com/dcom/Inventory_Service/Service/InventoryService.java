package com.dcom.Inventory_Service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcom.Inventory_Service.DTO.InventoryResponse;
import com.dcom.Inventory_Service.Repository.InventoryRepo;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;

	@Transactional(readOnly = true) // it will prevent to change in DB.
	public boolean isInStock(String skuCode) {

		return inventoryRepo.findBySkuCode(skuCode).isPresent();

	}

	@Transactional(readOnly = true)		// it will prevent to change in DB.
	public List<InventoryResponse> isInStocks(List<String> skuCodes) {
		

		System.out.println("Here is list: "+skuCodes.toString());
		
		return inventoryRepo.findBySkuCodeIn(skuCodes)
				.stream()
				.map(inventory->InventoryResponse.builder()
						.skuCode(inventory.getSkuCode())
						.quantity(inventory.getQuantity())
						.isInStock(inventory.getQuantity()>0)
						.build()
				).toList();
				
				

	}

}
