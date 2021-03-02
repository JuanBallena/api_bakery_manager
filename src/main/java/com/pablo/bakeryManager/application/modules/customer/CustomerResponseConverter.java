package com.pablo.bakeryManager.application.modules.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.application.modules.parameter.ParameterResponseConverter;
import com.pablo.bakeryManager.dominio.models.Customer;

@Component
public class CustomerResponseConverter extends ResponseConverter<Customer, CustomerResponse> {
	
	@Autowired
	private ParameterResponseConverter parameterResponseConverter;

	@Override
	public CustomerResponse convert(Customer customer) {
		
		return CustomerResponse.builder()
				.id(customer.getIdCustomer())
				.name(customer.getName())
				.phone(customer.getPhone())
				.status(parameterResponseConverter.convert(customer.getStatus()))
				.build();
	}
}
