package com.efitel.inventory.models.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	private Long categoryId;
	@NotNull
	@NotBlank
	private String categoryName;
	private String description;

}
