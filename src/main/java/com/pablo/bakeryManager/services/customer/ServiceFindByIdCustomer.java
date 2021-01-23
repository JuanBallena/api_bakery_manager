package com.pablo.bakeryManager.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.CustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindById;

@Service
public class ServiceFindByIdCustomer {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindById<Customer, CustomerDTO> serviceFindById;
	
	public ServiceResponse getData(Long idCustomer) {
		
		CustomerDTO customerDTO = serviceFindById.getData(idCustomer, customerRepository, customerConverter);
		
		if (customerDTO == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.CUSTOMER, customerDTO);
		}
		
		return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.CUSTOMER, customerDTO);
	}
}
