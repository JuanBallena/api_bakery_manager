package com.pablo.bakeryManager.application.modules.order;

import java.sql.Timestamp;

import com.pablo.bakeryManager.application.modules.customer.CustomerResponse;
import com.pablo.bakeryManager.application.modules.parameter.ParameterResponse;

import lombok.Builder;

@Builder
public class OrderResponse {

	public Long              id;
	public CustomerResponse  customer;
	public Double            fullPayment;
	public ParameterResponse turn;
	public Timestamp         tiemstamp;
	public ParameterResponse status;
}
