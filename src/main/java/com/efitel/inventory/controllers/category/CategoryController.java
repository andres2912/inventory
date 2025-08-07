package com.efitel.inventory.controllers.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efitel.inventory.models.dto.category.UpdateCategoryDTO;
import com.efitel.inventory.models.entity.category.CategoryEntity;
import com.efitel.inventory.services.category.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryEntity> createCategory(@Valid @RequestBody CategoryEntity categoryEntity) {
		return new ResponseEntity<>(categoryService.createCategory(categoryEntity), HttpStatus.CREATED);
	}

	@GetMapping("/getCategoryById/{categoryId}")
	public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Long categoryId) {
		return new ResponseEntity<>(categoryService.findCategoryById(categoryId), HttpStatus.OK);
	}

	@GetMapping("/getCategoryByName/{categoryName}")
	public ResponseEntity<CategoryEntity> getCategoryByName(@PathVariable String categoryName) {
		return new ResponseEntity<>(categoryService.getCategoryByName(categoryName), HttpStatus.OK);
	}

	@GetMapping("/categoriesByName/{categoryName}")
	public ResponseEntity<List<CategoryEntity>> categoriesByName(@PathVariable String categoryName) {
		return new ResponseEntity<>(categoryService.getCategoriesByName(categoryName), HttpStatus.OK);
	}

	@GetMapping("/getCategories")
	public ResponseEntity<List<CategoryEntity>> getCategories() {
		return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
	}

	@PatchMapping("/updateCategoryByName")
	public ResponseEntity<CategoryEntity> updateCategoryByName(@RequestBody UpdateCategoryDTO categoryDTO) {
		return new ResponseEntity<>(categoryService.updateCategoryByName(categoryDTO), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCategoryByName/{categoryName}")
	ResponseEntity<String> deleteCategoryByName(@PathVariable String categoryName){
		categoryService.deleteByCategoryName( categoryName);
		return  new ResponseEntity<>(categoryService.deleteByCategoryName(categoryName), HttpStatus.OK);
	}
}
