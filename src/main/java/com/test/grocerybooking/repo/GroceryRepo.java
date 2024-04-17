package com.test.grocerybooking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.grocerybooking.entity.Grocery;

@Repository
public interface GroceryRepo extends JpaRepository<Grocery, Integer>{

	void deleteById(int itemId);

	Optional<Grocery> findById(int itemId);

}
