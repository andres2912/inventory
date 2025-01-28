package com.efitel.inventory.services.category;

import java.util.List;

import com.efitel.inventory.models.dto.category.UpdateCategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;

public interface CategoryService {
	CategoryEntity createCategory(CategoryEntity categoryEntity);

	CategoryEntity getCategoryById(Long categoryId);

	CategoryEntity categoryByName(String categoryName);

	List<CategoryEntity> categoriesByName(String categoryName);

	List<CategoryEntity> getCategories();

	CategoryEntity updateCategoryByName(UpdateCategoryDTO categoryDTO);
	
	String deleteByCategoryName(String categoryName);

}
