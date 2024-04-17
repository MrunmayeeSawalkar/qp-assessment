package com.test.grocerybooking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.grocerybooking.entity.OrderGrocery;

@Repository
public interface OrderGroceryRepo extends JpaRepository<OrderGrocery, Integer> {

	
}
