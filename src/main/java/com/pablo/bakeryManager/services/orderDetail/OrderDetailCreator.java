package com.pablo.bakeryManager.services.orderDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderDetailConverter;
import com.pablo.bakeryManager.definition.ParameterDefinition;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.orderDetail.RequestCreateOrderDetailDTO;
import com.pablo.bakeryManager.dto.response.OrderDetailDTO;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.model.OrderDetail;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.OrderDetailRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class OrderDetailCreator {
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderDetailConverter orderDetailConverter;
	
	@Autowired
	private Creator<OrderDetail, OrderDetailDTO> creator;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse postData(RequestCreateOrderDetailDTO requestDTO) {
		
		List<Object> errorListOrderDetail = validatorRequestDTO.validate(requestDTO);
		
		if (errorListOrderDetail.isEmpty()) {
			
			OrderDetailDTO orderDetailDTO = this.saveData(requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.ORDER, orderDetailDTO);
		}
		
		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.ORDER, errorListOrderDetail);
	}
	
	private OrderDetailDTO saveData(RequestCreateOrderDetailDTO requestDTO) {
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrder(Order.builder().idOrder(requestDTO.getIdOrder()).build());
		orderDetail.setProduct(Product.builder().idProduct(requestDTO.getIdProduct()).build());
		orderDetail.setQuantity(requestDTO.getQuantity());
		orderDetail.setAmount(requestDTO.getAmount());
		orderDetail.setDiscount(requestDTO.getDiscount());
		orderDetail.setStatus(Parameter.builder().idParameter(ParameterDefinition.PARAMETER_COMPLETED_DETAIL).build());
		
		return creator.saveData(orderDetail, orderDetailRepository, orderDetailConverter);
	}
}
