package com.efitel.inventory.services.category;

import java.util.List;

import com.efitel.inventory.models.dto.category.UpdateCategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;

public interface CategoryService {
	/**
	 * Create and save a new category using the provided {@link CategoryEntity}.
	 * 
	 * @param categoryEntity The category entity to be created. Must not be
	 *                       {@code null}.
	 * @return The created {@link CategoryEntity} with generated ID field populated.
	 */
	CategoryEntity createCategory(CategoryEntity categoryEntity);

	/**
	 * Retrieves a category by its unique identifier.
	 * 
	 * @param categoryId The ID of the category to retrieve. Must not be
	 *                   {@code null}.
	 * @return {@link CategoryEntity} with the specified ID, or {@code null} if no
	 *         category is found.
	 */
	CategoryEntity getCategoryById(Long categoryId);

	/**
	 * Retrieves {@link CategoryEntity} that exactly matches the given name, ignoring
	 * case sensitivity.
	 * 
	 * @param categoryName The exact name of the category to search. Must not be
	 *                     {@code null}.
	 * @return The matching {@link CategoryEntity}, or {@code null} if no match is found.
	 */
	CategoryEntity getCategoryByName(String categoryName);

	/**
	 * Retrieves a list of categories whose names contain the given string. ignoring
	 * case sensitivity.
	 * 
	 * @param categoryName The string to search for within category name. Must not
	 *                     be {@code null}.
	 * @return A list of {@link CategoryEntity} objects whose names contain the
	 *         provided string. The list may be empty if no matching categories are
	 *         found.
	 */
	List<CategoryEntity> getCategoriesByName(String categoryName);

	/**
	 * Retrieves all categories.
	 * 
	 * @return A list of {@link CategoryEntity} objects representing all categories.
	 */

	List<CategoryEntity> getCategories();

	/**
	 * Update a category by its name.
	 * 
	 * @param categoryDTO must contain the current category name and the new name.
	 *                    Both must not be {@code null}. The description is optional
	 *                    description.
	 * @return The updated {@link CategoryEntity}.
	 */

	CategoryEntity updateCategoryByName(UpdateCategoryDTO categoryDTO);

	/**
	 * Delete a category by its name, ignoring case sensitivity.
	 * 
	 * @param categoryName The name of the category to delete. Must not be
	 *                     {@code null}.
	 * @return A confirmation message indicating the success of the operation.
	 */
	String deleteByCategoryName(String categoryName);

}
