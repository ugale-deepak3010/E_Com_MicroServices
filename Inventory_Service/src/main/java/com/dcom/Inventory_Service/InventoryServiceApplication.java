package com.dcom.Inventory_Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dcom.Inventory_Service.Model.Inventory;
import com.dcom.Inventory_Service.Repository.InventoryRepo;


@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		
//		Discovery Server dependency is added. Discovery Service must be up.

		SpringApplication.run(InventoryServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner loadData(InventoryRepo inventoryRepo) {

		return args -> {
			Inventory inventory = new Inventory();
			Inventory inventory2 = new Inventory();

			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);

			inventory2.setSkuCode("iphone_14");
			inventory2.setQuantity(0);

			inventoryRepo.save(inventory);
			inventoryRepo.save(inventory2);
		};
	}

}
