package com.pablo.bakeryManager.services.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderConverter;
import com.pablo.bakeryManager.definition.ParameterDefinition;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.order.RequestCreateOrderDTO;
import com.pablo.bakeryManager.dto.response.OrderDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.OrderRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.services.orderDetail.OrderDetailListCreator;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class OrderCreator {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Order, OrderDTO> creator;
	
	@Autowired
	private OrderDetailListCreator orderDetailListCreator;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;

	public ServiceResponse postData(RequestCreateOrderDTO requestDTO) {
		
		List<Object> errorListOrder = validatorRequestDTO.validate(requestDTO);
		
		if (errorListOrder.isEmpty()) {
			
			List<Object> errorListOrderDetailList = validatorRequestDTO.validate(requestDTO.getOrderDetailList());
			
			if (errorListOrderDetailList.isEmpty()) {
				
				OrderDTO orderDTO = this.saveData(requestDTO);
				
				orderDetailListCreator.postData(orderDTO.getId(), requestDTO.getOrderDetailList());
				
				return serviceResponseCreatorCreated.build(ResponseTypeDefinition.ORDER, orderDTO);
			}
			
			return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.ORDER, errorListOrderDetailList);
		}
			
		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.ORDER, errorListOrder);		
	}
	
	private OrderDTO saveData(RequestCreateOrderDTO requestDTO) {
		
		Order order = new Order();
		order.setCustomer(Customer.builder().idCustomer(requestDTO.getIdCustomer()).build());
		order.setFullPayment(15.0);
		order.setTurn(Parameter.builder().idParameter(requestDTO.getIdTurn()).build());
		order.setStatus(Parameter.builder().idParameter(ParameterDefinition.PARAMETER_COMPLETED).build());
		
		return creator.saveData(order, orderRepository, orderConverter);
	}
}
