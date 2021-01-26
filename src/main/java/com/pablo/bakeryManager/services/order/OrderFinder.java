package com.pablo.bakeryManager.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.OrderDTO;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.params.OrderParams;
import com.pablo.bakeryManager.repository.OrderRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ResponseToFinder;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.Finder;

@Service
public class OrderFinder {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private Finder<Order, OrderDTO> finder;
	
	@Autowired
	private ResponseToFinder responseToFinder;
	
	public ServiceResponse getData(OrderParams params) {
		
		PageResponse pageResponse = finder.getData(params, orderRepository, orderConverter);
		
		return responseToFinder.dispatch(ResponseTypeDefinition.ORDERS, pageResponse);
	}
}
