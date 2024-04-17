package com.test.grocerybooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.grocerybooking.entity.Grocery;
import com.test.grocerybooking.repo.GroceryRepo;

@Service
public class GroceryServiceImpl {
	
	@Autowired
	private GroceryRepo groceryRepo;

	public List<Grocery> addgrocerlist(List<Grocery> groceries) {
		return groceryRepo.saveAll(groceries);
	}

	public Grocery additem(Grocery grocery) {
		return groceryRepo.save(grocery);
	}

	public List<Grocery> getAllItems() {
		return groceryRepo.findAll();
	}

	public void deleteItem(int itemId) {
		groceryRepo.deleteById(itemId);
		
	}

	public String updateGrocery(int itemId,Grocery grocery) {
		Optional<Grocery> existingGroceryOptional = groceryRepo.findById(itemId);

		if (existingGroceryOptional.isPresent()) {
			Grocery existingGrocery = existingGroceryOptional.get();
			existingGrocery.setProductName(grocery.getProductName());
			existingGrocery.setProductPrice(grocery.getProductPrice());
			existingGrocery.setProductQuantity(grocery.getProductQuantity());
			groceryRepo.save(existingGrocery);
			return "Grocery is updated against "+itemId;
		}
		return "Grocery not present against "+itemId;
	}
}
