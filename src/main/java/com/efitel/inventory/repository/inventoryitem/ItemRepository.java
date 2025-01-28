package com.efitel.inventory.repository.inventoryitem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efitel.inventory.models.entity.inventoryItem.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
	List<ItemEntity> findByItemNameContainingIgnoreCase(String itemName);
	ItemEntity findByItemNameIgnoreCase(String itemName);
}
