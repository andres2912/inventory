package com.efitel.inventory.services.inventoryItem.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.efitel.inventory.mapper.category.CategoryMapper;
import com.efitel.inventory.models.dto.category.CategoryDTO;
import com.efitel.inventory.models.dto.inventoryItem.ItemDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.efitel.inventory.models.entity.inventoryItem.ItemEntity;
import com.efitel.inventory.repository.inventoryitem.ItemRepository;
import com.efitel.inventory.services.category.CategoryService;
import com.efitel.inventory.services.inventoryItem.ItemService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CategoryService categoryService;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public ItemEntity createUpdateItem(ItemDTO itemDTO) {
		CategoryDTO categoryDTO = categoryService.findCategoryById(itemDTO.getCategoryId());
		ItemEntity item;
		if (itemDTO.getItemId() != null) {
			item = findItemById(itemDTO.getItemId());
		} else {
			item = new ItemEntity();
		}
		CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(categoryDTO);
		item.setItemName(itemDTO.getItemName());
		item.setPrice(itemDTO.getPrice());
		item.setDescription(itemDTO.getDescription());
		item.setCategory(categoryEntity);
		return itemRepository.save(item);
		

	}

	@Override
	public ItemEntity findItemById(Long itemId) {
		return itemRepository.findById(itemId).orElseThrow(() -> {
			String errorMessage = messageSource.getMessage("notFound.itemById", new Object[] { itemId },
					Locale.getDefault());
			return new EntityNotFoundException(errorMessage);
		});

	}

	@Override
	public List<ItemEntity> findItemsByName(String itemName) {
		List<ItemEntity> items = itemRepository.findByItemNameContainingIgnoreCase(itemName);
		if (items.isEmpty()) {
			String errorMessage = messageSource.getMessage("notFound.items", new Object[] { itemName },
					Locale.getDefault());
			throw new EntityNotFoundException(errorMessage);
		}
		return items;
	}

	@Override
	public ItemEntity findItemByName(String itemName) {
		return itemRepository.findByItemNameIgnoreCase(itemName).orElseThrow(() -> {
			String errorMessage = messageSource.getMessage("notFound.itemByName", new Object[] { itemName },
					Locale.getDefault());
			throw new EntityNotFoundException(errorMessage);
		});
	}

	@Override
	public List<ItemEntity> getItems() {
		List<ItemEntity> items = itemRepository.findAll();
		if (items.isEmpty()) {
			String errorMessage = messageSource.getMessage("notFound.allItems", null, Locale.getDefault());
			throw new EntityNotFoundException(errorMessage);
		}
		return items;
	}

	@Override
	public String deleteByItemName(String itemName) {
		try {
			itemRepository.deleteByItemName(itemName);
			return "Item deleted succesfully";
		} catch (Exception e) {
			return null;
		}
	}
}
