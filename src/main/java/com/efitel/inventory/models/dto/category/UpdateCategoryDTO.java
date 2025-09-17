package com.efitel.inventory.models.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryDTO {
	@NotBlank
	@NotNull
	private String currentCategoryName;
	@NotBlank
	@NotNull
	private String newCategoryName;
	private String description;
}
