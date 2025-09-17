package com.efitel.inventory.controllers.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efitel.inventory.models.dto.item.ItemDTO;
import com.efitel.inventory.models.entity.item.ItemEntity;
import com.efitel.inventory.services.item.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inventoryItem")
public class ItemController {
	@Autowired
	ItemService itemService;

	@PostMapping
	ResponseEntity<ItemDTO> createUpdateItem(@Valid @RequestBody ItemDTO Item) {
		return new ResponseEntity<>(itemService.createUpdateItem(Item), HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<ItemDTO>> getItems() {
		return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
	}
	
	@GetMapping("/id")
	ResponseEntity<ItemDTO> findItemById(@PathVariable Long id) {
		return new ResponseEntity<>(itemService.findItemById(id), HttpStatus.OK);
	}

	@GetMapping("/{name}")
	ResponseEntity<List<ItemDTO>> getItemsByName(@PathVariable String name) {
		return new ResponseEntity<>(itemService.findItemsByName(name), HttpStatus.OK);
	}

	@GetMapping("/getItemByName/{itemName}")
	ResponseEntity<ItemDTO> getItembyName(@PathVariable String itemName) {
		return new ResponseEntity<>(itemService.findItemByName(itemName), HttpStatus.OK);
	}

	@DeleteMapping("/deleteByItemName/{itemName}")
	ResponseEntity<String> deleteByItemName(@PathVariable String itemName){
		return new ResponseEntity<>(itemService.deleteByItemName(itemName), HttpStatus.OK);
	}

}
