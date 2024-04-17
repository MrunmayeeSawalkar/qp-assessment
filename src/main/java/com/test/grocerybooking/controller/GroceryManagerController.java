package com.test.grocerybooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.grocerybooking.entity.Grocery;
import com.test.grocerybooking.service.GroceryServiceImpl;

@RestController
@RequestMapping("/adminUser")
public class GroceryManagerController {
	
	@Autowired
	private GroceryServiceImpl groceryservice;
	
	@PostMapping("/addItemsList")
	public ResponseEntity<List<Grocery>> addGroceryList(@RequestBody List<Grocery> groceries){
		List<Grocery> groclist=null;
		try {
			groclist=groceryservice.addgrocerlist(groceries);
			return new ResponseEntity<List<Grocery>>(groclist, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@PostMapping("/addItem")
	public ResponseEntity<Grocery> addGrocery(@RequestBody Grocery grocery ){
		Grocery items=null;
		try {
			items=groceryservice.additem(grocery);
			return new ResponseEntity<Grocery>(items, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Grocery>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/fetchAllItems")
	public ResponseEntity<List<Grocery>> fetchItems(){
		List<Grocery> list=groceryservice.getAllItems();
		if(list.size()<=0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Grocery>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeItems/{itemId}")
	public ResponseEntity<String> removeItems(@PathVariable("itemId") int itemId ){
		try {
			groceryservice.deleteItem(itemId);
			return new ResponseEntity<>(HttpStatus.OK);		
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("updateItem/{itemId}")
	public String updateItem(@PathVariable("itemId")
	int itemId,@RequestBody Grocery grocery){
		String message=null;
		try {
			message=groceryservice.updateGrocery(itemId,grocery);
			return message;
			
		}catch(Exception e) {
			e.printStackTrace();
			return message;
		}
	}
	
	
}
