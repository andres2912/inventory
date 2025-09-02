package com.efitel.inventory.repository.item;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efitel.inventory.models.entity.item.ItemEntity;

import jakarta.transaction.Transactional;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
	/**
	 *  * Retrieves a list of items whose names contain the given string, ignoring case
	 * sensitivity.
	 * Retrieves an item by its name, ignoring case sensitivity.
	 * 
	 * @param itemName The exact name of the item. Must not be {@code null}.
	 * @return A {@link ItemEntity} that matches the provided name, or {@code null}
	 *         if no match is found.
	 */
	List<ItemEntity> findByItemNameContainingIgnoreCase(String itemName);

	/**
	 * Retrieves an item by its name, ignoring case sensitivity.
	 * 
	 * @param itemName The string to search for within item names. Must not be
	 *                 {@code null}.
	 * @return A list of {@link ItemEntity} objects whose names contain the provided
	 *         string. The list may be empty if no matching items are found.
	 */

	Optional<ItemEntity> findByItemNameIgnoreCase(String itemName);

	/**
	 * Delete an item by its name, ignore case sensitivity.
	 * 
	 * @param itemName The name of the item to delete. Must not be {@code null}.
	 */
	@Transactional
	void deleteByItemName(String itemName);
}
