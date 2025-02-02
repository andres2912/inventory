package com.efitel.inventory.controllers.inventoryitem;

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

import com.efitel.inventory.models.dto.inventoryItem.CreateItemDTO;
import com.efitel.inventory.models.dto.inventoryItem.UpdateItemDTO;
import com.efitel.inventory.models.entity.inventoryItem.ItemEntity;
import com.efitel.inventory.repository.inventoryitem.ItemRepository;
import com.efitel.inventory.services.inventoryItem.ItemService;

@RestController
@RequestMapping("/inventoryItem")
public class ItemController {
	@Autowired
	ItemService itemService;

	@PostMapping
	ResponseEntity<ItemEntity> createItem(@RequestBody CreateItemDTO Item) {
		return new ResponseEntity<>(itemService.createItem(Item), HttpStatus.CREATED);
	}

	@GetMapping("/getItemById/{itemId}")
	ResponseEntity<ItemEntity> getItemById(@PathVariable Long itemId) {
		return new ResponseEntity<>(itemService.getItemById(itemId), HttpStatus.OK);
	}

	@GetMapping("/getItemsByName/{itemName}")
	ResponseEntity<List<ItemEntity>> getItemsByName(@PathVariable String itemName) {
		return new ResponseEntity<>(itemService.getItemsByName(itemName), HttpStatus.OK);
	}

	@GetMapping("/getItemByName/{itemName}")
	ResponseEntity<ItemEntity> getItembyName(@PathVariable String itemName) {
		return new ResponseEntity<>(itemService.getItemByName(itemName), HttpStatus.OK);
	}

	@GetMapping("/getAllItems")
	ResponseEntity<List<ItemEntity>> getAllItems() {
		return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
	}

	@PatchMapping("/updateItemByName")
	ResponseEntity<ItemEntity> updateItemByName(@RequestBody UpdateItemDTO Item) {
		return new ResponseEntity<>(itemService.updateItem(Item), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByItemName/{itemName}")
	ResponseEntity<String> deleteByItemName(@PathVariable String itemName){
		return new ResponseEntity<>(itemService.deleteByItemName(itemName), HttpStatus.OK);
	}
	

}
