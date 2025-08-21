package com.efitel.inventory.models.entity.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long categoryId;
	@NotNull(message = "The category name is mandatory")
	@NotBlank(message = "The category name is mandatory")
	@Column(name = "category_name", nullable = false, unique = true)
	private String categoryName;
	@Column(columnDefinition = "TEXT")
	private String description;

}
