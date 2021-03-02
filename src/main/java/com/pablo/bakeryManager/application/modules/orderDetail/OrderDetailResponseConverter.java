package com.pablo.bakeryManager.application.modules.orderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.application.modules.order.OrderResponseConverter;
import com.pablo.bakeryManager.application.modules.parameter.ParameterResponseConverter;
import com.pablo.bakeryManager.application.modules.product.ProductResponseConverter;
import com.pablo.bakeryManager.dominio.models.OrderDetail;

@Component
public class OrderDetailResponseConverter extends ResponseConverter<OrderDetail, OrderDetailResponse> {
	
	@Autowired
	private OrderResponseConverter orderResponseConverter;
	
	@Autowired
	private ProductResponseConverter productResponseConverter;
	
	@Autowired
	private ParameterResponseConverter parameterResponseConverter;

	@Override
	public OrderDetailResponse convert(OrderDetail orderDetail) {
		
		return OrderDetailResponse.builder()
				.id(orderDetail.getIdOrderDetail())
				.order(orderResponseConverter.convert(orderDetail.getOrder()))
				.product(productResponseConverter.convert(orderDetail.getProduct()))
				.quantity(orderDetail.getQuantity())
				.amount(orderDetail.getAmount())
				.discount(orderDetail.getDiscount())
				.status(parameterResponseConverter.convert(orderDetail.getStatus()))
				.build();
	}
}
