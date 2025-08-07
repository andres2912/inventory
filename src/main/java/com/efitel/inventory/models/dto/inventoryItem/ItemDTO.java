package com.efitel.inventory.models.dto.inventoryItem;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemDTO {
	@NotNull(message = "CategoryId is mandatory.")
	private Long itemId;
	private Long categoryId;
	@NotNull(message = "itemName is mandatory.")
	@NotBlank(message = "itemName is mandatory.")
	private String itemName;
	private BigDecimal price;
	private String description;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoriId) {
		this.categoryId = categoriId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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
