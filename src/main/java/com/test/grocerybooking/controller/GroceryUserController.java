package com.test.grocerybooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.grocerybooking.entity.Grocery;
import com.test.grocerybooking.entity.OrderGrocery;
import com.test.grocerybooking.service.OrderGroceryServiceImpl;

@RestController
@RequestMapping("/User")
public class GroceryUserController {
	
	@Autowired
	private OrderGroceryServiceImpl orderservice;
	
	@GetMapping("/getAllItems")
	public ResponseEntity<List<Grocery>> getItems(){
		List<Grocery> list=orderservice.getAllItems();
		if(list.size()<=0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Grocery>>(list, HttpStatus.OK);
	}
	
	
	 
	@PostMapping("/booking")
	public ResponseEntity<OrderGrocery> createOrder(@RequestBody OrderGrocery order){
		OrderGrocery savedorder=orderservice.saveOrder(order);
		return new ResponseEntity<OrderGrocery>(savedorder, HttpStatus.OK);
	}
	
	
}
