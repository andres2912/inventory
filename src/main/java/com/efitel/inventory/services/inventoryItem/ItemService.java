package com.efitel.inventory.services.inventoryItem;

import java.util.List;

import com.efitel.inventory.models.dto.inventoryItem.CreateItemDTO;
import com.efitel.inventory.models.dto.inventoryItem.UpdateItemDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.efitel.inventory.models.entity.inventoryItem.ItemEntity;

public interface ItemService {
	/**
	 * Create and save a new inventory item using the provided
	 * {@link CreateItemDTO}.
	 * 
	 * @param itemDTO the DTO containing the details of the item to be created. The
	 *                {code itemName} attribute must not be {@code null}.
	 * @return The created {@link ItemEntity} whit generated ID field populated.
	 */
	ItemEntity createItem(CreateItemDTO itemDTO);

	/**
	 * Retrieves an item by its unique identifier.
	 * 
	 * @param itemId The ID of the item to retrieve. Must not be {@code null}.
	 * @return The matching {@link ItemEntity}, or {@code null} if no match is
	 *         found.
	 */
	ItemEntity getItemById(Long itemId);

	/**
	 * Retrieves an {@link ItemEntity} that exactly matches the given name, ignoring
	 * case sensitivity
	 * 
	 * @param itemName The exact name of the item to search. Must not be
	 *                 {@code null}.
	 * @return An {@link ItemEntity} that matches the provided name, or {@code null}
	 *         if no match is found.
	 */
	ItemEntity getItemByName(String itemName);

	/**
	 * Retrieves a list of items whose names contain the given string. ignoring case
	 * sensitivity.
	 * 
	 * @param itemName The string to search for within the item names. Must not be
	 *                 {@code null}.
	 * @return A list of {@link ItemEntity} objects whose names contain the provided
	 *         string. The list may be empty if no matching items are found.
	 */
	List<ItemEntity> getItemsByName(String itemName);

	/**
	 * Retrieves all items
	 * 
	 * @return A list of {@link ItemEntity} objects representing all items.
	 */
	List<ItemEntity> getItems();

	/**
	 * Update an item by its name.
	 * 
	 * @param itemDTO must contain the current item name and the new name; these
	 *                attributes must not be {@code null}.
	 * @return the updated {@link ItemEntity}.
	 */
	ItemEntity updateItem(UpdateItemDTO itemDTO);

	/**
	 * Delete an item by its name, ignoring case sensitivity.
	 * 
	 * @param itemName The name of the item to delete. Must not be {@code null}.
	 * @return A confirmation message indicating the success of the operation.
	 */
	String deleteByItemName(String itemName);

}
