package com.pablo.bakeryManager.application.modules.customer.customerUpdater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.exception.BadRequestExceptionHandler;
import com.pablo.bakeryManager.application.exception.NotFoundExceptionHandler;
import com.pablo.bakeryManager.application.modules.Id;
import com.pablo.bakeryManager.application.modules.customer.CustomerResponse;
import com.pablo.bakeryManager.application.modules.customer.CustomerResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseBadRequest;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseCreated;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNotFound;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.CommandHandler;
import com.pablo.bakeryManager.dominio.models.Customer;

@Component
public class CustomerUpdaterCommandHandler implements CommandHandler<CustomerUpdaterCommand, ServiceResponse> {

	@Autowired
	private CustomerUpdater customerUpdater;
	
	@Autowired
	private CustomerResponseConverter customerResponseConverter;

	@Override
	public ServiceResponse handle(CustomerUpdaterCommand command) {
		
		try {
			
			Id id = new Id(command.idCustomer);
			
			CustomerUpdaterRequest request = CustomerUpdaterRequest.create(command.request);
			
			Customer customer = customerUpdater.update(id.value(), request);
			
			CustomerResponse customerResponse = customerResponseConverter.convert(customer);
			
			return new ServiceResponseCreated(ResourceType.CUSTOMER, customerResponse);
		
		} catch (BadRequestExceptionHandler e) {
			return new ServiceResponseBadRequest(ResourceType.CATEGORY, e.exceptionInfo());
			
		} catch (NotFoundExceptionHandler e) {
			return new ServiceResponseNotFound(ResourceType.CATEGORY, e.exceptionInfo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
