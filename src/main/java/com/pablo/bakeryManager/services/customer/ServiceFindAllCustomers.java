package com.pablo.bakeryManager.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.CustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.request.CustomerRequest;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindAll;

@Service
public class ServiceFindAllCustomers {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindAll<Customer, CustomerDTO> serviceFindAll;
	
	public ServiceResponse getData(CustomerRequest request) {
		
		PageResponse pageResponse = serviceFindAll.getData(request, customerRepository, customerConverter);
		
		if (pageResponse.hasData()) {
			
			return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.CUSTOMERS, pageResponse);
		}
		
		return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.CUSTOMERS, pageResponse);
	}
}
