package com.pablo.bakeryManager.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.OrderDTO;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.repository.OrderRepository;
import com.pablo.bakeryManager.response.ResponseToFinderById;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.FinderById;

@Service
public class OrderFinderById {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderConverter converter;
	
	@Autowired
	private FinderById<Order, OrderDTO> finderById;
	
	@Autowired
	private ResponseToFinderById responseToFinderById;
	
	public ServiceResponse getData(Long idOrder) {
		
		OrderDTO orderDTO = finderById.getData(idOrder, repository, converter);
		
		return responseToFinderById.dispatch(ResponseTypeDefinition.ORDER, orderDTO);
	}
}
