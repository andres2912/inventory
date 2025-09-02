package com.efitel.inventory.services.item.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.efitel.inventory.mapper.category.CategoryMapper;
import com.efitel.inventory.mapper.item.ItemMapper;
import com.efitel.inventory.models.dto.category.CategoryDTO;
import com.efitel.inventory.models.dto.item.ItemDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.efitel.inventory.models.entity.item.ItemEntity;
import com.efitel.inventory.repository.item.ItemRepository;
import com.efitel.inventory.services.category.CategoryService;
import com.efitel.inventory.services.item.ItemService;

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

	@Autowired
	ItemMapper itemMapper;

	@Override
	public ItemDTO createUpdateItem(ItemDTO itemDTO) {
		CategoryDTO categoryDTO = categoryService.findCategoryById(itemDTO.getCategoryId());
		ItemDTO item;
		if (itemDTO.getItemId() != null) {
			item = findItemById(itemDTO.getItemId());
		} else {
			item = new ItemDTO();
		}
		CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(categoryDTO);
		item.setItemName(itemDTO.getItemName());
		item.setPrice(itemDTO.getPrice());
		item.setDescription(itemDTO.getDescription());
		item.setCategory(categoryEntity);
		ItemEntity itemToSave = itemMapper.toItemEntity(item);
		ItemEntity saved = itemRepository.save(itemToSave);
		return itemMapper.toItemDTO(saved);

	}

	@Override
	public ItemDTO findItemById(Long itemId) {
		ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow(() -> {
			String errorMessage = messageSource.getMessage("notFound.itemById", new Object[] { itemId },
					Locale.getDefault());
			return new EntityNotFoundException(errorMessage);
		});

		return itemMapper.toItemDTO(itemEntity);

	}

	@Override
	public List<ItemDTO> findItemsByName(String itemName) {

		List<ItemDTO> itemDtoList = new ArrayList<>();
		List<ItemEntity> items = itemRepository.findByItemNameContainingIgnoreCase(itemName);
		if (items.isEmpty()) {
			String errorMessage = messageSource.getMessage("notFound.items", new Object[] { itemName },
					Locale.getDefault());
			throw new EntityNotFoundException(errorMessage);
		}
		for (ItemEntity item : items) {
			itemDtoList.add(itemMapper.toItemDTO(item));
		}

		return itemDtoList;
	}

	@Override
	public ItemDTO findItemByName(String itemName) {
		ItemEntity itemEntity = itemRepository.findByItemNameIgnoreCase(itemName).orElseThrow(() -> {
			String errorMessage = messageSource.getMessage("notFound.itemByName", new Object[] { itemName },
					Locale.getDefault());
			throw new EntityNotFoundException(errorMessage);
		});

		return itemMapper.toItemDTO(itemEntity);

	}

	@Override
	public List<ItemDTO> getItems() {
		List<ItemDTO> itemDtoList = new ArrayList<>();
		List<ItemEntity> items = itemRepository.findAll();
		if (items.isEmpty()) {
			String errorMessage = messageSource.getMessage("notFound.allItems", null, Locale.getDefault());
			throw new EntityNotFoundException(errorMessage);
		}
		for (ItemEntity item : items) {
			itemDtoList.add(itemMapper.toItemDTO(item));
		}

		return itemDtoList;
	}

	@Override
	public String deleteByItemName(String itemName) {
		try {
			itemRepository.deleteByItemName(itemName);
			return "Item deleted successfully";
		} catch (Exception e) {
			return null;
		}
	}
}
