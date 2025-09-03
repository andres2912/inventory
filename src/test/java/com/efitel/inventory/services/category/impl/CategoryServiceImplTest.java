package com.efitel.inventory.services.category.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
	
	
	
	@Test
	void createCategoryTest() {
		CategoryDTO categoryToSave  = new CategoryDTO();
		categoryToSave .setCategoryName("categoryTest");
		categoryToSave .setDescription("category description");
		
		CategoryEntity mappedEntity = new CategoryEntity();
        mappedEntity.setCategoryName("categoryTest");
        mappedEntity.setDescription("category description");
		
		CategoryEntity savedEntity = new CategoryEntity();
        savedEntity.setCategoryId(1L);
        savedEntity.setCategoryName("categoryTest");
        savedEntity.setDescription("category description");
        
        CategoryDTO savedCategoryDto = new CategoryDTO();
        savedCategoryDto.setCategoryId(1L);
        savedCategoryDto.setCategoryName("categoryTest");
        savedCategoryDto.setDescription("category description");
        
		when(categoryMapper.toCategoryEntity(categoryToSave )).thenReturn(mappedEntity);
		when(categoryMapper.toCategoryDTO(savedEntity)).thenReturn(savedCategoryDto);
        when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(savedEntity);
		
		
		CategoryDTO savedCategory= categoryServiceImpl.createCategory(categoryToSave);
		
		assertNotNull(savedCategory);
		assertEquals(savedCategoryDto.getCategoryId(), savedCategory.getCategoryId());
		assertEquals(savedCategoryDto.getCategoryName(), savedCategory.getCategoryName());
		assertEquals(savedCategoryDto.getDescription(), savedCategory.getDescription());	
		
		InOrder inOrder = Mockito.inOrder(categoryMapper, categoryRepository);
		inOrder.verify(categoryMapper).toCategoryEntity(categoryToSave);
		inOrder.verify(categoryRepository).save(any(CategoryEntity.class));
		inOrder.verify(categoryMapper).toCategoryDTO(savedEntity);
	}

}
