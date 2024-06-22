package com.dcom.Inventory_Service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcom.Inventory_Service.Repository.InventoryRepo;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;

	@Transactional(readOnly = true)		// it will prevent to change in DB.
	public boolean isInStock(String skuCode) {

		return inventoryRepo.findBySkuCode(skuCode).isPresent();

	}

}
