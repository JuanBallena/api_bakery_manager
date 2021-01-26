package com.pablo.bakeryManager.controller.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.params.OrderParams;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.order.OrderFinder;
import com.pablo.bakeryManager.services.order.OrderFinderById;

@RestController
public class OrdersGetController {

	@Autowired
	private OrderFinder orderFinder;
	
	@Autowired
	private OrderFinderById orderFinderById;
	
	@GetMapping("/orders")
	public ServiceResponse getOrders(OrderParams params) {

		return orderFinder.getData(params);
	}
	
	@GetMapping("/orders/{idOrder}")
	public ServiceResponse getOrder(@PathVariable("idOrder") Long idOrder) {
		
		return orderFinderById.getData(idOrder);
	}
}
