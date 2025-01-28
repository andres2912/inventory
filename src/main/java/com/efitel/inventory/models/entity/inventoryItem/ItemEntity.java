package com.efitel.inventory.models.entity.inventoryItem;

import java.math.BigDecimal;

import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_item")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long itemId;
	@Column(name = "item_name", nullable = false, unique = true)
	private String itemName;
	@Column(nullable = true)
	private BigDecimal price;
	@Column(columnDefinition = "TEXT")
	private String description;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity categoriId) {
		this.category = categoriId;
	}

}
