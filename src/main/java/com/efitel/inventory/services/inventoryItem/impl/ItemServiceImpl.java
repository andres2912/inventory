package com.efitel.inventory.services.inventoryItem.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efitel.inventory.models.dto.inventoryItem.CreateItemDTO;
import com.efitel.inventory.models.dto.inventoryItem.UpdateItemDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.efitel.inventory.models.entity.inventoryItem.ItemEntity;
import com.efitel.inventory.repository.inventoryitem.ItemRepository;
import com.efitel.inventory.services.category.CategoryService;
import com.efitel.inventory.services.inventoryItem.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CategoryService categoryService;

	@Override
	public ItemEntity createItem(CreateItemDTO itemDTO) {
		CategoryEntity category = categoryService.getCategoryById(itemDTO.getCategoryId());
		ItemEntity item = new ItemEntity();
		item.setItemName(itemDTO.getItemName());
		item.setPrice(itemDTO.getPrice());
		item.setDescription(itemDTO.getDescription());
		item.setCategory(category);

		return itemRepository.save(item);
	}

	@Override
	public ItemEntity getItemById(Long itemId) {
		return itemRepository.getReferenceById(itemId);
	}

	@Override
	public List<ItemEntity> getItemsByName(String itemName) {
		return itemRepository.findByItemNameContainingIgnoreCase(itemName);
	}

	@Override
	public

			ItemEntity getItemByName(String itemName) {
		return itemRepository.findByItemNameIgnoreCase(itemName);
	}

	@Override
	public List<ItemEntity> getAllItems() {
		return itemRepository.findAll();

	}

	@Override
	public ItemEntity updateItem(UpdateItemDTO itemDTO) {
		ItemEntity updateItem = itemRepository.findByItemNameIgnoreCase(itemDTO.getCurrentItemName());
		updateItem.setItemName(itemDTO.getNewItemName());
		updateItem.setPrice(itemDTO.getPrice());
		updateItem.setDescription(itemDTO.getDescription());
		if (Objects.nonNull(itemDTO.getCategoryId())) {
			CategoryEntity category = categoryService.getCategoryById(itemDTO.getCategoryId());
			updateItem.setCategory(category);
		}
		return itemRepository.save(updateItem);
	}
}
