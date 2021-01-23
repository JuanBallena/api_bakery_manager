package com.pablo.bakeryManager.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.OrderDTO;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.repository.OrderRepository;
import com.pablo.bakeryManager.request.OrderRequest;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindAll;

@Service
public class ServiceFindAllOrders {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindAll<Order, OrderDTO> serviceFindAll;
	
	public ServiceResponse getData(OrderRequest request) {
		
		PageResponse pageResponse = serviceFindAll.getData(request, repository, orderConverter);
		
		if (pageResponse.hasData()) {
			
			return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.ORDERS, pageResponse);
		}
		
		return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.ORDERS, pageResponse);
	}
}
