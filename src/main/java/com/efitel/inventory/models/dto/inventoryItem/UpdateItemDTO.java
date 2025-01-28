package com.efitel.inventory.models.dto.inventoryItem;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class UpdateItemDTO {
	private Long categoryId;
	@NotNull
	@NotBlank
	private String currentItemName;
	@NotNull
	@NotBlank
	private String newItemName;
	private BigDecimal price;
	private String description;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCurrentItemName() {
		return currentItemName;
	}

	public void setCurrentItemName(String currentItemName) {
		this.currentItemName = currentItemName;
	}

	public String getNewItemName() {
		return newItemName;
	}

	public void setNewItemName(String newItemName) {
		this.newItemName = newItemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
