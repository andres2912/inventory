package com.efitel.inventory.models.dto.inventoryItem;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
	@NotNull(message = "CategoryId is mandatory.")
	private Long itemId;
	private Long categoryId;
	@NotNull(message = "itemName is mandatory.")
	@NotBlank(message = "itemName is mandatory.")
	private String itemName;
	private BigDecimal price;
	private String description;

}
