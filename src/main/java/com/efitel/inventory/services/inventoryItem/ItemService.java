package com.efitel.inventory.services.inventoryItem;

import java.util.List;

import com.efitel.inventory.models.dto.inventoryItem.CreateItemDTO;
import com.efitel.inventory.models.dto.inventoryItem.UpdateItemDTO;
import com.efitel.inventory.models.entity.inventoryItem.ItemEntity;

public interface ItemService {
	ItemEntity createItem(CreateItemDTO itemDTO);

	ItemEntity getItemById(Long itemId);

	ItemEntity getItemByName(String itemName);

	List<ItemEntity> getItemsByName(String itemName);

	List<ItemEntity> getAllItems();

	ItemEntity updateItem(UpdateItemDTO itemDTO);
	
	String deleteByItemName(String itemName);

}
