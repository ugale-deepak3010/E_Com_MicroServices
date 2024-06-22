package com.dcom.Inventory_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dcom.Inventory_Service.Service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;

	@GetMapping("/{skuCode}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean isInStock(@PathVariable String skuCode) {

		return inventoryService.isInStock(skuCode);
	}

}
