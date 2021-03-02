package com.pablo.bakeryManager.application.modules.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.application.modules.customer.CustomerResponseConverter;
import com.pablo.bakeryManager.application.modules.parameter.ParameterResponseConverter;
import com.pablo.bakeryManager.dominio.models.Order;

@Component
public class OrderResponseConverter extends ResponseConverter<Order, OrderResponse> {
	
	@Autowired
	private CustomerResponseConverter customerResponseConverter;
	
	@Autowired
	private ParameterResponseConverter parameterResponseConverter;

	@Override
	public OrderResponse convert(Order order) {
		
		return OrderResponse.builder()
				.id(order.getIdOrder())
				.customer(customerResponseConverter.convert(order.getCustomer()))
				.fullPayment(order.getFullPayment())
				.turn(parameterResponseConverter.convert(order.getTurn()))
				.tiemstamp(order.getTimestamp())
				.status(parameterResponseConverter.convert(order.getStatus()))
				.build();
	}
}
