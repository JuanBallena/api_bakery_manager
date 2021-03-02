package com.pablo.bakeryManager.application.modules.customer;

import com.pablo.bakeryManager.application.modules.parameter.ParameterResponse;

import lombok.Builder;

@Builder
public class CustomerResponse {

	public Long              id;
	public String            name;
	public String            phone;
	public ParameterResponse status;
}
