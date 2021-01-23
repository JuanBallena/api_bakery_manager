package com.pablo.bakeryManager.controller.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.request.OrderRequest;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.order.ServiceFindAllOrders;
import com.pablo.bakeryManager.services.order.ServiceFindByIdOrder;

@RestController
public class OrdersGetController {

	@Autowired
	private ServiceFindAllOrders serviceFindAllOrders;
	
	@Autowired
	private ServiceFindByIdOrder serviceFindByIdOrder;
	
	@GetMapping("/orders")
	public ServiceResponse getOrders(OrderRequest request) {

		return serviceFindAllOrders.getData(request);
	}
	
	@GetMapping("/orders/{idOrder}")
	public ServiceResponse getOrder(@PathVariable("idOrder") Long idOrder) {
		
		return serviceFindByIdOrder.getData(idOrder);
	}
}
