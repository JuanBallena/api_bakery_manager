package com.pablo.bakeryManager.controller.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.order.RequestCreateOrderDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.order.OrderCreator;

@RestController
public class OrdersPostController {

	@Autowired
	private OrderCreator orderCreator;
	
	@PostMapping("/orders")
	public ServiceResponse saveOrder(@RequestBody RequestCreateOrderDTO requestDTO) {
		
		return orderCreator.postData(requestDTO);
	}
}
