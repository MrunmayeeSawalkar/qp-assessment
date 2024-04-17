package com.test.grocerybooking.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class OrderGrocery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@OneToMany(targetEntity = Grocery.class ,cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id",referencedColumnName ="orderid" )
	private List<Grocery> orders;
	
	
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public List<Grocery> getOrders() {
		return orders;
	}

	public void setOrders(List<Grocery> orders) {
		this.orders = orders;
	}


	

}
