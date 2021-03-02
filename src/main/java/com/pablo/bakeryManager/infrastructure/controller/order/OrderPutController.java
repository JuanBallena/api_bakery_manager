package com.pablo.bakeryManager.infrastructure.controller.order;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.order.orderUpdater.OrderUpdaterCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateOrder;

@RestController
public class OrderPutController extends ApiController {
	
	@PutMapping("/orders/{id}")
	public Response putOrder(@PathVariable("id") Long idOrder, @RequestBody RequestUpdateOrder request) {
		
		return super.dispatch(new OrderUpdaterCommand(idOrder, request));
	}
}
