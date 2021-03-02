package com.pablo.bakeryManager.application.modules.customer.customerFinder;

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
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNotFound;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseOk;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;
import com.pablo.bakeryManager.dominio.models.Customer;

@Component
public class CustomerFinderQueryHandler implements QueryHandler<CustomerFinderQuery, ServiceResponse>{

	@Autowired
	private CustomerFinder customerFinder;
	
	@Autowired
	private CustomerResponseConverter customerResponseConverter; 
	
	@Override
	public ServiceResponse handle(CustomerFinderQuery query) {
		
		try {
			
			Id id = new Id(query.idCustomer);
			
			Customer customer = customerFinder.find(id.value());
			
			CustomerResponse customerResponse = customerResponseConverter.convert(customer);
			
			return new ServiceResponseOk(ResourceType.CUSTOMER, customerResponse);
			
		} catch (BadRequestExceptionHandler e) {
			return new ServiceResponseBadRequest(ResourceType.CUSTOMER, e.exceptionInfo());
			
		} catch (NotFoundExceptionHandler e) {
			return new ServiceResponseNotFound(ResourceType.CUSTOMER, e.exceptionInfo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
