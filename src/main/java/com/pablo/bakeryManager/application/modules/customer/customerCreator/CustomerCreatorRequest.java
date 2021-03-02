package com.pablo.bakeryManager.application.modules.customer.customerCreator;

import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;
import com.pablo.bakeryManager.application.modules.customer.valueObject.CustomerName;
import com.pablo.bakeryManager.application.modules.customer.valueObject.CustomerPhone;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateCustomer;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomerCreatorRequest {

	private CustomerName customerName;
	private CustomerPhone customerPhone;
	
	public static final CustomerCreatorRequest create(RequestCreateCustomer request) throws RequestBodyExceptionHandler {
		
		return CustomerCreatorRequest.builder()
				.customerName(new CustomerName(request.name))
				.customerPhone(new CustomerPhone(request.phone))
				.build();
	}	
}
