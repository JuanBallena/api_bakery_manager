package com.pablo.bakeryManager.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.CustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.params.CustomerParams;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ResponseToFinder;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.Finder;

@Service
public class CustomerFinder {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private Finder<Customer, CustomerDTO> finder;
	
	@Autowired
	private ResponseToFinder responseToFinder;
	
	public ServiceResponse getData(CustomerParams params) {
		
		PageResponse pageResponse = finder.getData(params, customerRepository, customerConverter);
		
		return responseToFinder.dispatch(ResponseTypeDefinition.CUSTOMERS, pageResponse);
	}
}
