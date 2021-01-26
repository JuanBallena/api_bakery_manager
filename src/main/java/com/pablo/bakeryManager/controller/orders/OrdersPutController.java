package com.pablo.bakeryManager.controller.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.order.RequestUpdateOrderDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.order.OrderUpdater;

@RestController
public class OrdersPutController {

	@Autowired
	private OrderUpdater orderUpdater;
	
	@PutMapping("/orders/{idOrder}")
	public ServiceResponse updateOrder(@PathVariable("idOrder") Long idOrder, @RequestBody RequestUpdateOrderDTO requestDTO) {
		
		return orderUpdater.putData(idOrder, requestDTO);
	}
}
