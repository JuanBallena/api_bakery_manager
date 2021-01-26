package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.response.OrderDTO;
import com.pablo.bakeryManager.dto.response.OrderDetailDTO;
import com.pablo.bakeryManager.dto.response.ParameterDTO;
import com.pablo.bakeryManager.dto.response.ProductDTO;
import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.model.OrderDetail;

@Component
public class OrderDetailConverter implements Converter<OrderDetail, OrderDetailDTO> {

	@Override
	public OrderDetailDTO toDTO(OrderDetail od) {
		
		return OrderDetailDTO.builder()
				.id(od.getIdOrderDetail())
				.order(OrderDTO.builder()
						.id(od.getOrder().getIdOrder())
						.build())
				.product(ProductDTO.builder()
						.id(od.getProduct().getIdProduct())
						.build())
				.quantity(od.getQuantity())
				.amount(od.getAmount())
				.discount(od.getDiscount())
				.status(ParameterDTO.builder()
						.id(od.getStatus().getIdParameter())
						.description(od.getStatus().getDescription())
						.build())
				.build();
	}

	@Override
	public List<OrderDetailDTO> toDTOList(List<OrderDetail> orderDetailList) {
		
		List<OrderDetailDTO> orderDetailDTOList = new ArrayList<OrderDetailDTO>();
		orderDetailList.forEach(orderDetail -> orderDetailDTOList.add(toDTO(orderDetail)));
		return orderDetailDTOList;
	}

}
