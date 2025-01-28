package com.efitel.inventory.repository.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efitel.inventory.models.entity.category.CategoryEntity;

import jakarta.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findByCategoryNameIgnoreCase(String categoryName);

	List<CategoryEntity> findByCategoryNameContainingIgnoreCase(String categoryName);

	@Transactional
	void deleteByCategoryNameIgnoreCase(String categoryName);

}
