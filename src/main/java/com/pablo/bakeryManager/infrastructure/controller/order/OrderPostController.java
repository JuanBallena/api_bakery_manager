package com.pablo.bakeryManager.infrastructure.controller.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.order.orderCreator.OrderCreatorCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateOrder;

@RestController
public class OrderPostController extends ApiController {
	
	@PostMapping("/orders")
	public Response postOrder(@RequestBody RequestCreateOrder request) {
		
		return super.dispatch(new OrderCreatorCommand(request));
	}
}
