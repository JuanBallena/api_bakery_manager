package com.pablo.bakeryManager.services.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ParameterDefinition;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.OrderDTO;
import com.pablo.bakeryManager.dto.order.RequestCreateOrderDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.OrderRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.services.orderDetail.ServiceCreateOrderDetailList;
import com.pablo.bakeryManager.validator.ValidatorRequestCreateOrderDTO;

@Service
public class ServiceCreateOrder {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ValidatorRequestCreateOrderDTO validatorRequestCreateOrderDTO;
	
	@Autowired
	private ServiceSave<Order, OrderDTO> serviceSave;
	
	@Autowired
	private ServiceCreateOrderDetailList serviceCreateOrderDetailList;
	
	public ServiceResponse postData(RequestCreateOrderDTO requestDTO) {
		
		List<Object> errorList = validatorRequestCreateOrderDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			Order order = this.createOrder(requestDTO);

			OrderDTO orderDTO = serviceSave.postData(order, orderRepository, orderConverter);
			
			serviceCreateOrderDetailList.postData(orderDTO.getId(), requestDTO.getOrderDetailList());
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.ORDER, orderDTO);
		}
			
		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.ORDER, errorList);		
	}
	
	private Order createOrder(RequestCreateOrderDTO requestDTO) {
		
		return Order.builder()
				.customer(Customer.builder().idCustomer(requestDTO.getIdCustomer()).build())
				.fullPayment(15.0)
				.turn(Parameter.builder().idParameter(requestDTO.getIdTurn()).build())
				.status(Parameter.builder().idParameter(ParameterDefinition.PARAMETER_COMPLETED).build())
				.build();
	}
}
