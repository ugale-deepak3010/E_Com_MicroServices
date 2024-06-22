package com.dcom.Inventory_Service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcom.Inventory_Service.Model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findBySkuCode(String skuCode);

}
