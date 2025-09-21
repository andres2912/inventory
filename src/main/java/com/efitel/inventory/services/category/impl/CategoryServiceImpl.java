package com.efitel.inventory.services.category.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.efitel.inventory.mapper.category.CategoryMapper;
import com.efitel.inventory.models.dto.category.CategoryDTO;
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
	
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public CategoryDTO createUpdateCategory(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity;
		CategoryEntity saved;
		if (categoryDTO.getCategoryId() != null) {
			CategoryDTO categoryToUpdate = findCategoryById(categoryDTO.getCategoryId());
			categoryToUpdate.setCategoryName(categoryDTO.getCategoryName());
			categoryToUpdate.setDescription(categoryDTO.getDescription());
			categoryEntity = categoryMapper.toCategoryEntity(categoryToUpdate);
			saved = categoryRepository.save(categoryEntity);
		} else {
			categoryEntity = categoryMapper.toCategoryEntity(categoryDTO);
			saved = categoryRepository.save(categoryEntity);
		}
		return categoryMapper.toCategoryDTO(saved);
	}

	@Override
	public CategoryDTO findCategoryById(Long categoryId) {		
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow(() -> {
			String errorMessage = messageSource.getMessage("notFound.category", new Object[] { categoryId },
					Locale.getDefault());
			return new EntityNotFoundException(errorMessage);
		});
		
		return categoryMapper.toCategoryDTO(categoryEntity);
	}	

	@Override
	public List<CategoryDTO> getCategoriesByName(String categoryName) {
		List<CategoryEntity> categoryEntities = new ArrayList<>();
		List<CategoryDTO> categoryDtoList = new ArrayList<>();
		categoryEntities = categoryRepository.findByCategoryNameContainingIgnoreCase(categoryName);

		for (CategoryEntity category : categoryEntities) {
			categoryDtoList.add(categoryMapper.toCategoryDTO(category));
		}

		return categoryDtoList;

	}

	@Override
	public List<CategoryDTO> getCategories() {
		List<CategoryEntity> categoryEntities = new ArrayList<>();
		List<CategoryDTO> categoryDtoList = new ArrayList<>();
		categoryEntities = categoryRepository.findAll();

		for (CategoryEntity category : categoryEntities) {
			categoryDtoList.add(categoryMapper.toCategoryDTO(category));
		}
		return categoryDtoList;

	}

	@Override
	public String deleteCategoryById(Long categoryId) {
		try {
			categoryRepository.deleteById(categoryId);
			return "Category deleted succesfully";
		} catch (Exception e) {
			return null;
		}

	}

}
