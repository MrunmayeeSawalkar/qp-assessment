package com.test.grocerybooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.grocerybooking.entity.Grocery;
import com.test.grocerybooking.entity.OrderGrocery;
import com.test.grocerybooking.repo.GroceryRepo;
import com.test.grocerybooking.repo.OrderGroceryRepo;

@Service
public class OrderGroceryServiceImpl {

	@Autowired
	private OrderGroceryRepo ordergroceryRepo;
	
	@Autowired
	private GroceryRepo grocerrepo;
	
	public List<Grocery> getAllItems() {
		return grocerrepo.findAll();
	}

	public OrderGrocery saveOrder(OrderGrocery order) {
		return ordergroceryRepo.save(order);
	}

	
	
}
