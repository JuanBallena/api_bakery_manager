package com.pablo.bakeryManager.controller.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.order.RequestCreateOrderDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.order.ServiceCreateOrder;

@RestController
public class OrdersPostController {

	@Autowired
	private ServiceCreateOrder serviceCreateOrder;
	
	@PostMapping("/orders")
	public ServiceResponse saveOrder(@RequestBody RequestCreateOrderDTO requestDTO) {
		
		return serviceCreateOrder.postData(requestDTO);
	}
}
