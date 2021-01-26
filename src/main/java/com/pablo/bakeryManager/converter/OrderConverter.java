package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.response.CustomerDTO;
import com.pablo.bakeryManager.dto.response.OrderDTO;
import com.pablo.bakeryManager.dto.response.ParameterDTO;
import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.model.Order;

@Component
public class OrderConverter implements Converter<Order, OrderDTO> {

	@Override
	public OrderDTO toDTO(Order o) {
		
		return OrderDTO.builder()
				.id(o.getIdOrder())
				.customer(CustomerDTO.builder()
						.id(o.getCustomer().getIdCustomer())
						.name(o.getCustomer().getName())
						.build())
				.fullPayment(o.getFullPayment())
				.turn(ParameterDTO.builder()
						.id(o.getTurn().getIdParameter())
						.description(o.getTurn().getDescription())
						.build())
				.tiemstamp(o.getTimestamp())
				.status(ParameterDTO.builder()
						.id(o.getStatus().getIdParameter())
						.description(o.getStatus().getDescription())
						.build())
				.build();
	}

	@Override
	public List<OrderDTO> toDTOList(List<Order> orderList) {
		
		List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
		orderList.forEach(order -> orderDTOList.add(toDTO(order)));
		return orderDTOList;
	}

}
