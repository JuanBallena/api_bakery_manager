package com.pablo.bakeryManager.services.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.order.RequestUpdateOrderDTO;
import com.pablo.bakeryManager.dto.response.OrderDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.OrderRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.response.ServiceResponseCreatorNotFound;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.services.DatabaseChecker;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class OrderUpdater {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private DatabaseChecker<Order> databaseChecker;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Order, OrderDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorNotFound serviceResponseCreatorNotFound;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse putData(Long idOrder, RequestUpdateOrderDTO requestDTO) {
		
		Order order = databaseChecker.check(idOrder, orderRepository);
		
		if (order == null) {
			
			return serviceResponseCreatorNotFound.build(ResponseTypeDefinition.ORDER);
		}
		
		List<Object> errorListOrder =  validatorRequestDTO.validate(requestDTO);
		
		if (errorListOrder.isEmpty()) {
			
			OrderDTO orderDTO = this.saveData(order, requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.ORDER, orderDTO);
		}

		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.ORDER, errorListOrder);
	}
	
	private OrderDTO saveData(Order order, RequestUpdateOrderDTO requestDTO) {
		
		order.setCustomer(Customer.builder().idCustomer(requestDTO.getIdCustomer()).build());
		order.setFullPayment(15.5);
		order.setTurn(Parameter.builder().idParameter(requestDTO.getIdTurn()).build());
		order.setStatus(Parameter.builder().idParameter(requestDTO.getIdStatus()).build());
		
		return creator.saveData(order, orderRepository, orderConverter);
	}
}
