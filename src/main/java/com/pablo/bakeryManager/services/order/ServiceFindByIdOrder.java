package com.pablo.bakeryManager.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.OrderDTO;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.repository.OrderRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindById;

@Service
public class ServiceFindByIdOrder {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderConverter converter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindById<Order, OrderDTO> serviceFindById;
	
	public ServiceResponse getData(Long idOrder) {
		
		OrderDTO orderDTO = serviceFindById.getData(idOrder, repository, converter);
		
		if (orderDTO == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.ORDER, orderDTO);
		}
		
		return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.ORDER, orderDTO);
	}
}
