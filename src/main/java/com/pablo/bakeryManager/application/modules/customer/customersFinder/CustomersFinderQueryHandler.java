package com.pablo.bakeryManager.application.modules.customer.customersFinder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.criteria.paging.Pagination;
import com.pablo.bakeryManager.application.modules.customer.CustomerResponse;
import com.pablo.bakeryManager.application.modules.customer.CustomerResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNoContent;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseOk;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;
import com.pablo.bakeryManager.dominio.models.Customer;

@Component
public class CustomersFinderQueryHandler implements QueryHandler<CustomersFinderQuery, ServiceResponse>{

	@Autowired
	private CustomersFinder customersFinder;
	
	@Autowired
	private CustomerResponseConverter customerResponseConverter;
	
	@Override
	public ServiceResponse handle(CustomersFinderQuery query) {
		
		try {
			
			CustomersFinderCriteria criteria = new CustomersFinderCriteria(CustomersFinderRequest.create(query.params));
			
			Pagination<Customer> pagination = customersFinder.find(criteria);
			
			if (pagination.hasData()) {
				
				List<CustomerResponse> customersResponse = customerResponseConverter.convertList(pagination.getData());
				
				return new ServiceResponseOk(ResourceType.CUSTOMERS, customersResponse, pagination.getTotalPages());
			}
			
			return new ServiceResponseNoContent(ResourceType.CUSTOMERS, pagination.getData());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
