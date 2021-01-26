package com.pablo.bakeryManager.services.orderDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.OrderDetailConverter;
import com.pablo.bakeryManager.definition.ParameterDefinition;
import com.pablo.bakeryManager.dto.request.order.RequestOrderDetail;
import com.pablo.bakeryManager.dto.response.OrderDetailDTO;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.model.OrderDetail;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.OrderDetailRepository;
import com.pablo.bakeryManager.services.Creator;

@Service
public class OrderDetailListCreator {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderDetailConverter orderDetailConverter;
	
	@Autowired
	private Creator<OrderDetail, OrderDetailDTO> creator;
	
	public void postData(Long idOrder, List<RequestOrderDetail> requestOrderDetailList) {
		
		for (RequestOrderDetail requestOrderDetail : requestOrderDetailList) {
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(Order.builder().idOrder(idOrder).build());
			orderDetail.setProduct(Product.builder().idProduct(requestOrderDetail.getIdProduct()).build());
			orderDetail.setQuantity(requestOrderDetail.getQuantity());
			orderDetail.setAmount(requestOrderDetail.getAmount());
			orderDetail.setDiscount(requestOrderDetail.getDiscount());
			orderDetail.setStatus(Parameter.builder().idParameter(ParameterDefinition.PARAMETER_COMPLETED_DETAIL).build());
			
			creator.saveData(orderDetail, orderDetailRepository, orderDetailConverter);
		}
	}
}
