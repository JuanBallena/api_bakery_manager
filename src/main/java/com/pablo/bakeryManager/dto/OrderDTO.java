package com.pablo.bakeryManager.dto;

import java.sql.Timestamp;

import com.pablo.bakeryManager.interf.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class OrderDTO implements ResponseDTO {

	private Long id;
	private CustomerDTO customer;
	private Double fullPayment;
	private ParameterDTO turn;
	private Timestamp tiemstamp;
	private ParameterDTO status;
}
