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

import com.efitel.inventory.models.dto.category.CategoryDTO;
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
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getCategories() {
		return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
		return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
		return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<List<CategoryDTO>> categoriesByName(@PathVariable String name) {
		return new ResponseEntity<>(categoryService.getCategoriesByName(name), HttpStatus.OK);
	}

	

	@PatchMapping("/{id}")
	public ResponseEntity<CategoryDTO> updateCategoryByName(@PathVariable Long id, @RequestBody UpdateCategoryDTO dataToUpdate) {
		return new ResponseEntity<>(categoryService.updateCategoryByName(id, dataToUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{categoryName}")
	ResponseEntity<String> deleteCategoryByName(@PathVariable String categoryName){
		categoryService.deleteByCategoryName( categoryName);
		return  new ResponseEntity<>(categoryService.deleteByCategoryName(categoryName), HttpStatus.OK);
	}
}
