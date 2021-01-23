package com.pablo.bakeryManager.services.orderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderDetailConverter;
import com.pablo.bakeryManager.definition.ParameterDefinition;
import com.pablo.bakeryManager.dto.OrderDetailDTO;
import com.pablo.bakeryManager.dto.orderDetail.RequestCreateOrderDetailDTO;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.model.OrderDetail;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.OrderDetailRepository;
import com.pablo.bakeryManager.services.ServiceSave;

@Service
public class ServiceCreateOrderDetail {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderDetailConverter orderDetailConverter;
	
	@Autowired
	private ServiceSave<OrderDetail, OrderDetailDTO> serviceSave;
	
	public void postData(Long idOrder, RequestCreateOrderDetailDTO requestDTO) {
		
		OrderDetail orderDetail = this.createOrderDetail(idOrder, requestDTO);
		
		serviceSave.postData(orderDetail, orderDetailRepository, orderDetailConverter);
	}
	
	private OrderDetail createOrderDetail(Long idOrder, RequestCreateOrderDetailDTO requestDTO) {
		
		return OrderDetail.builder()
				.order(Order.builder().idOrder(idOrder).build())
				.product(Product.builder().idProduct(requestDTO.getIdProduct()).build())
				.quantity(requestDTO.getQuantity())
				.amount(requestDTO.getAmount())
				.discount(requestDTO.getDiscount())
				.status(Parameter.builder().idParameter(ParameterDefinition.PARAMETER_COMPLETED_DETAIL).build())
				.build();
	}
}
