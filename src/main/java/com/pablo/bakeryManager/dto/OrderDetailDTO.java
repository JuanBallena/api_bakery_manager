package com.pablo.bakeryManager.dto;

import com.pablo.bakeryManager.interf.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class OrderDetailDTO implements ResponseDTO {

	private Long id;
	private OrderDTO order;
	private ProductDTO product;
	private Double quantity;
	private Double amount;
	private Double discount;
	private ParameterDTO status;
}
