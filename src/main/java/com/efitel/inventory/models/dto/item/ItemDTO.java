package com.efitel.inventory.models.dto.item;

import java.math.BigDecimal;

import com.efitel.inventory.models.entity.category.CategoryEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
	private Long itemId;
	@NotNull(message = "CategoryId is mandatory.")
	private Long categoryId;
	@NotNull(message = "itemName is mandatory.")
	@NotBlank(message = "itemName is mandatory.")
	private String itemName;
	private BigDecimal price;
	private String description;
	private CategoryEntity category;

}
