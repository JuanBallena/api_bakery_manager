package com.pablo.bakeryManager.application.modules.customer.customerUpdater;

import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;
import com.pablo.bakeryManager.application.modules.customer.valueObject.CustomerIdStatus;
import com.pablo.bakeryManager.application.modules.customer.valueObject.CustomerName;
import com.pablo.bakeryManager.application.modules.customer.valueObject.CustomerPhone;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateCustomer;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomerUpdaterRequest {

	private CustomerName customerName;
	private CustomerPhone customerPhone;
	private CustomerIdStatus customerIdStatus;
	
	public static final CustomerUpdaterRequest create(RequestUpdateCustomer request) throws RequestBodyExceptionHandler {
		
		return CustomerUpdaterRequest.builder()
				.customerName(new CustomerName(request.name))
				.customerPhone(new CustomerPhone(request.phone))
				.customerIdStatus(new CustomerIdStatus(request.idStatus))
				.build();
	}
}
