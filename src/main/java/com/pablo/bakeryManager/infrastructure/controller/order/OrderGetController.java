package com.pablo.bakeryManager.infrastructure.controller.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.order.orderFinder.OrderFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;

@RestController
public class OrderGetController extends ApiController {

	@GetMapping("/orders/{id}")
	public Response getOrder(@PathVariable("id") Long idOrder) {
		
		return super.ask(new OrderFinderQuery(idOrder));
	}
}
