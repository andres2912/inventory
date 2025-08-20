package com.efitel.inventory.models.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class UpdateCategoryDTO {
	private Long categoryId;
	@NotBlank
	@NotNull
	private String currentCategoryName;
	@NotBlank
	@NotNull
	private String newCategoryName;
	private String description;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCurrentCategoryName() {
		return currentCategoryName;
	}

	public void setCurrentCategoryName(String currentCategoryName) {
		this.currentCategoryName = currentCategoryName;
	}

	public String getNewCategoryName() {
		return newCategoryName;
	}

	public void setNewCategoryName(String newCategoryName) {
		this.newCategoryName = newCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
