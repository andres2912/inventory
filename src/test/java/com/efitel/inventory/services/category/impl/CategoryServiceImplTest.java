package com.efitel.inventory.services.category.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.efitel.inventory.mapper.category.CategoryMapper;
import com.efitel.inventory.models.dto.category.CategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.efitel.inventory.repository.category.CategoryRepository;
import com.efitel.inventory.services.category.CategoryService;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

	@InjectMocks
	private CategoryServiceImpl categoryServiceImpl;

	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	CategoryMapper categoryMapper;

	private CategoryEntity savedEntity;

	@BeforeEach
	void setUp() {
		savedEntity = new CategoryEntity();
		savedEntity.setCategoryId(1L);
		savedEntity.setCategoryName("categoryTest");
		savedEntity.setDescription("category description");
	}

	@Test
	void createCategoryTest() {
		CategoryDTO categoryToSave = new CategoryDTO();
		categoryToSave.setCategoryName("categoryTest");
		categoryToSave.setDescription("category description");

		CategoryEntity mappedEntity = new CategoryEntity();
		mappedEntity.setCategoryId(categoryToSave.getCategoryId());
		mappedEntity.setCategoryName(categoryToSave.getCategoryName());
		mappedEntity.setDescription(categoryToSave.getDescription());

		CategoryDTO savedCategoryDto = new CategoryDTO();
		savedCategoryDto.setCategoryId(savedEntity.getCategoryId());
		savedCategoryDto.setCategoryName(savedEntity.getCategoryName());
		savedCategoryDto.setDescription(savedEntity.getDescription());

		when(categoryMapper.toCategoryEntity(any(CategoryDTO.class))).thenReturn(mappedEntity);
		when(categoryMapper.toCategoryDTO(savedEntity)).thenReturn(savedCategoryDto);
		when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(savedEntity);

		CategoryDTO savedCategory = categoryServiceImpl.createUpdateCategory(categoryToSave);

		assertNotNull(savedCategory);
		assertEquals(savedCategoryDto.getCategoryId(), savedCategory.getCategoryId());
		assertEquals(savedCategoryDto.getCategoryName(), savedCategory.getCategoryName());
		assertEquals(savedCategoryDto.getDescription(), savedCategory.getDescription());

		InOrder inOrder = Mockito.inOrder(categoryMapper, categoryRepository);
		inOrder.verify(categoryMapper).toCategoryEntity(categoryToSave);
		inOrder.verify(categoryRepository).save(any(CategoryEntity.class));
		inOrder.verify(categoryMapper).toCategoryDTO(savedEntity);
	}

	@Test
	void updateCategoryTest() {
		CategoryDTO category = new CategoryDTO();
		category.setCategoryId(1L);
		category.setCategoryName("Category to update");
		category.setDescription("Category updated");

		CategoryEntity categoryUpdated = new CategoryEntity();
		categoryUpdated.setCategoryId(savedEntity.getCategoryId());
		categoryUpdated.setCategoryName(category.getCategoryName());
		categoryUpdated.setDescription(category.getDescription());
		
		CategoryDTO existingCategoryDto = new CategoryDTO();
		existingCategoryDto.setCategoryId(savedEntity.getCategoryId());
		existingCategoryDto.setCategoryName(savedEntity.getCategoryName());
		existingCategoryDto.setDescription(savedEntity.getDescription());
		
		CategoryDTO savedCategoryDto = new CategoryDTO();
		savedCategoryDto.setCategoryId(category.getCategoryId());
		savedCategoryDto.setCategoryName(category.getCategoryName());
		savedCategoryDto.setDescription(category.getDescription());
		
		when(categoryMapper.toCategoryDTO(eq(savedEntity))).thenReturn(existingCategoryDto);
		when(categoryMapper.toCategoryDTO(eq(categoryUpdated))).thenReturn(savedCategoryDto);
		when(categoryMapper.toCategoryEntity(any(CategoryDTO.class))).thenReturn(categoryUpdated);
		when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(savedEntity));
		when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(categoryUpdated);
		
		CategoryDTO CategoryUpdated = categoryServiceImpl.createUpdateCategory(category);
		
		assertNotNull(CategoryUpdated);
		assertEquals(savedEntity.getCategoryId(), CategoryUpdated.getCategoryId());
		assertEquals(category.getCategoryName(), CategoryUpdated.getCategoryName());
		assertEquals(category.getDescription(), CategoryUpdated.getDescription());
		
		InOrder inOrder = Mockito.inOrder(categoryMapper, categoryRepository);
		inOrder.verify(categoryRepository).findById(anyLong());
		inOrder.verify(categoryRepository).save(any(CategoryEntity.class));
		inOrder.verify(categoryMapper).toCategoryDTO(categoryUpdated);
	}
}
