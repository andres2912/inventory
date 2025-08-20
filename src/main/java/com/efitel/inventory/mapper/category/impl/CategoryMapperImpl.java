package com.efitel.inventory.mapper.category.impl;

import com.efitel.inventory.mapper.category.CategoryMapper;
import com.efitel.inventory.models.dto.category.CategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;

public class CategoryMapperImpl implements CategoryMapper {
	@Override
	public CategoryEntity toCategoryEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryId(categoryDTO.getCategoryId());
		categoryEntity.setCategoryName(categoryDTO.getCategoryName());
		categoryEntity.setDescription(categoryDTO.getDescription());
		return categoryEntity;

	}

	@Override
	public CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(categoryEntity.getCategoryId());
		categoryDTO.setCategoryName(categoryEntity.getCategoryName());
		categoryDTO.setDescription(categoryEntity.getDescription());
		return categoryDTO;
	}
}
