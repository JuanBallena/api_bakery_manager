package com.pablo.bakeryManager.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.CustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.response.ResponseToFinderById;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.FinderById;

@Service
public class CustomerFinderById {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private FinderById<Customer, CustomerDTO> finderById;
	
	@Autowired
	private ResponseToFinderById responseToFinderById;
	
	public ServiceResponse getData(Long idCustomer) {
		
		CustomerDTO customerDTO = finderById.getData(idCustomer, customerRepository, customerConverter);
		
		return responseToFinderById.dispatch(ResponseTypeDefinition.CUSTOMER, customerDTO);
	}
}
