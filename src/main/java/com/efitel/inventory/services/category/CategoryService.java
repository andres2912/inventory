package com.efitel.inventory.services.category;

import java.util.List;
import java.util.Optional;

import com.efitel.inventory.models.dto.category.CategoryDTO;
import com.efitel.inventory.models.dto.category.UpdateCategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;

public interface CategoryService {
	/**
	 * Create or update a category using the provided {@link CategoryDTO}.
	 * 
	 * @param CategoryDTO The category to be created. Must not be
	 *                       {@code null}.
	 * @return The created {@link CategoryDTO} with generated ID field populated.
	 */
	CategoryDTO createUpdateCategory(CategoryDTO categoryDTO);

	/**
	 * Retrieves a category by its unique identifier.
	 * 
	 * @param categoryId The ID of the category to retrieve. Must not be
	 *                   {@code null}.
	 * @return {@link CategoryDTO} with the specified ID, or {@code null} if no
	 *         category is found.
	 */
	CategoryDTO findCategoryById(Long categoryId);

	/**
	 * Retrieves {@link CategoryDTO} that exactly matches the given name, ignoring
	 * case sensitivity.
	 * 
	 * @param categoryName The exact name of the category to search. Must not be
	 *                     {@code null}.
	 * @return The matching {@link CategoryDTO}, or {@code null} if no match is found.
	 */
	CategoryDTO getCategoryByName(String categoryName);

	/**
	 * Retrieves a list of categories whose names contain the given string. ignoring
	 * case sensitivity.
	 * 
	 * @param categoryName The string to search for within category name. Must not
	 *                     be {@code null}.
	 * @return A list of {@link CategoryDTO} objects whose names contain the
	 *         provided string. The list may be empty if no matching categories are
	 *         found.
	 */
	List<CategoryDTO> getCategoriesByName(String categoryName);

	/**
	 * Retrieves all categories.
	 * 
	 * @return A list of {@link CategoryDTO} objects representing all categories.
	 */

	List<CategoryDTO> getCategories();

	/**
	 * Delete a category by its id.
	 * 
	 * @param categoryId The id of the category to delete. Must not be
	 *                     {@code null}.
	 * @return A confirmation message indicating the success of the operation.
	 */
	String deleteCategoryById(Long categoryId);

}
