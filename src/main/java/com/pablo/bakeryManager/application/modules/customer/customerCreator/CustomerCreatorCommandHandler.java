package com.pablo.bakeryManager.application.modules.customer.customerCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.exception.BadRequestExceptionHandler;
import com.pablo.bakeryManager.application.modules.customer.CustomerResponse;
import com.pablo.bakeryManager.application.modules.customer.CustomerResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseBadRequest;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseCreated;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.CommandHandler;
import com.pablo.bakeryManager.dominio.models.Customer;

@Component
public class CustomerCreatorCommandHandler implements CommandHandler<CustomerCreatorCommand, ServiceResponse> {

	@Autowired
	private CustomerCreator customerCreator;
	
	@Autowired
	private CustomerResponseConverter customerResponseConverter;
	
	@Override
	public ServiceResponse handle(CustomerCreatorCommand command) {
		
		try {
			
			CustomerCreatorRequest request = CustomerCreatorRequest.create(command.request);
			
			Customer customer = customerCreator.create(request);
			
			CustomerResponse customerResponse = customerResponseConverter.convert(customer);
			
			return new ServiceResponseCreated(ResourceType.CUSTOMER, customerResponse);
			
		} catch (BadRequestExceptionHandler e) {
			return new ServiceResponseBadRequest(ResourceType.CUSTOMER, e.exceptionInfo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}

}
