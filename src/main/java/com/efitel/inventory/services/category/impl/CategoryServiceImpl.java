package com.efitel.inventory.services.category.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.efitel.inventory.models.dto.category.CategoryDTO;
import com.efitel.inventory.models.dto.category.UpdateCategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.efitel.inventory.repository.category.CategoryRepository;
import com.efitel.inventory.services.category.CategoryService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	MessageSource messageSource;

	@Override
	public CategoryEntity createCategory(CategoryDTO categoryEntity) {
		CategoryMapper
			return categoryRepository.save(categoryEntity);
	}

	@Override
	public CategoryEntity findCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(() -> {
			String errorMessage = messageSource.getMessage("notFound.category", new Object[] { categoryId },
					Locale.getDefault());
			return new EntityNotFoundException(errorMessage);
		});
	}	

	@Override
	public CategoryEntity getCategoryByName(String categoryName) {
		return categoryRepository.findByCategoryNameIgnoreCase(categoryName);
	}

	@Override
	public List<CategoryEntity> getCategoriesByName(String categoryName) {
		return categoryRepository.findByCategoryNameContainingIgnoreCase(categoryName);

	}

	@Override
	public List<CategoryEntity> getCategories() {
		return categoryRepository.findAll();

	}

	@Override
	public CategoryEntity updateCategoryByName(UpdateCategoryDTO categoryDTO) {
		CategoryEntity updateCategory = getCategoryByName(categoryDTO.getCurrentCategoryName());
		updateCategory.setCategoryName(categoryDTO.getNewCategoryName());
		updateCategory.setDescription(categoryDTO.getDescription());
		return categoryRepository.save(updateCategory);
	}

	@Override
	public String deleteByCategoryName(String categoryName) {
		try {
			categoryRepository.deleteByCategoryNameIgnoreCase(categoryName);
			return "Category deleted succesfully";
		} catch (Exception e) {
			return null;
		}

	}

}
