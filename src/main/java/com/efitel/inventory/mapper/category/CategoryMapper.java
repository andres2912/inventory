package com.efitel.inventory.mapper.category;

import org.mapstruct.Mapper;

import com.efitel.inventory.mapper.CentralMappingConfig;
import com.efitel.inventory.models.dto.category.CategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;

@Mapper(config = CentralMappingConfig.class)
public interface CategoryMapper {
	CategoryEntity toCategoryEntity(CategoryDTO categoryDTO);

	CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);
}
