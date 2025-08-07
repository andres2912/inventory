package com.efitel.inventory.services.inventoryItem;

import java.util.List;

import com.efitel.inventory.models.dto.inventoryItem.ItemDTO;
import com.efitel.inventory.models.entity.inventoryItem.ItemEntity;

public interface ItemService {
	/**
	 * Create or update inventory item using the provided
	 * {@link ItemDTO}.
	 * 
	 * @param itemDTO the DTO containing the details of the item to be created. The
	 *                {code itemName} attribute must not be {@code null}.
	 * @return The created {@link ItemEntity} with generated ID field populated.
	 */
	ItemEntity createUpdateItem(ItemDTO itemDTO);

	/**
	 * Retrieves an item by its unique identifier.
	 * 
	 * @param itemId The ID of the item to retrieve. Must not be {@code null}.
	 * @return The matching {@link ItemEntity}, or {@code null} if no match is
	 *         found.
	 */
	ItemEntity findItemById(Long itemId);

	/**
	 * Retrieves an {@link ItemEntity} that exactly matches the given name, ignoring
	 * case sensitivity
	 * 
	 * @param itemName The exact name of the item to search. Must not be
	 *                 {@code null}.
	 * @return An {@link ItemEntity} that matches the provided name, or {@code null}
	 *         if no match is found.
	 */
	ItemEntity findItemByName(String itemName);

	/**
	 * Retrieves a list of items whose names contain the given string. ignoring case
	 * sensitivity.
	 * 
	 * @param itemName The string to search for within the item names. Must not be
	 *                 {@code null}.
	 * @return A list of {@link ItemEntity} objects whose names contain the provided
	 *         string. The list may be empty if no matching items are found.
	 */
	List<ItemEntity> findItemsByName(String itemName);

	/**
	 * Retrieves all items
	 * 
	 * @return A list of {@link ItemEntity} objects representing all items.
	 */
	List<ItemEntity> getItems();

	/**
	 * Delete an item by its name, ignoring case sensitivity.
	 * 
	 * @param itemName The name of the item to delete. Must not be {@code null}.
	 * @return A confirmation message indicating the success of the operation.
	 */
	String deleteByItemName(String itemName);

}
