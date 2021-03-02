package com.pablo.bakeryManager.application.criteria.sorting;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class OrderCreator {
	
	 public static final Order create(String property, String direction) {

		if (direction.equals("asc")) {
			
			return new Order(Direction.ASC, property);
		}
		
		return new Order(Direction.DESC, property);
	}
}



