package com.pablo.bakeryManager.infrastructure.controller.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.order.ordersFinder.OrdersFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestParams.OrderRequestParams;

@RestController
public class OrdersGetController extends ApiController {
	
	@GetMapping("/orders")
	public Response getOrders(OrderRequestParams request) {
		
		return super.ask(new OrdersFinderQuery(request));
	}
}
