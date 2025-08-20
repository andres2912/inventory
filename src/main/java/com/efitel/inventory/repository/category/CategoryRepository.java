package com.efitel.inventory.repository.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efitel.inventory.models.entity.category.CategoryEntity;

import jakarta.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	/**
	 * Retrieves a category by its name, ignoring case sensitivity.
	 * 
	 * @param categoryName The exact name of the category. Must not be {@code null}.
	 * @return A {@link CategoryEntity} that  matches the provided name, or
	 *         {@code null} if no match is found.
	 */
	CategoryEntity findByCategoryNameIgnoreCase(String categoryName);

	/**
	 * Retrieves a list of categories whose names contain the given string, ignoring
	 * case sensitivity.
	 * 
	 * @param categoryName The string to search for within category name. Must not
	 *                     be {@code null}.
	 * @return A list of {@link CategoryEntity} objects whose names contain the
	 *         provided string. The list may be empty if no matching categories are
	 *         found.
	 */

	List<CategoryEntity> findByCategoryNameContainingIgnoreCase(String categoryName);

	/**
	 * Delete a category by its name, ignore case sensitivity. 
	 * 
	 * @param categoryName The name of the category to delete. Must not be
	 *                     {@code null}.
	 */
	@Transactional
	void deleteByCategoryNameIgnoreCase(String categoryName);

}
