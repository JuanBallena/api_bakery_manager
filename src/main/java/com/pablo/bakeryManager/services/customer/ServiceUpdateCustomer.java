package com.pablo.bakeryManager.services.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.CustomerDTO;
import com.pablo.bakeryManager.dto.customer.RequestUpdateCustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceVerifyDB;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceUpdateCustomer {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter converter;
	
	@Autowired
	private ServiceVerifyDB<Customer> serviceVerifyDB;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceSave<Customer, CustomerDTO> serviceSave;
	
	public ServiceResponse putData(Long idCustomer, RequestUpdateCustomerDTO requestDTO) {
		
		Customer customer = serviceVerifyDB.check(idCustomer, customerRepository);
		
		if (customer == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.CUSTOMER);
		}
		
		List<Object> errorList =  validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			customer.setName(requestDTO.getName());
			customer.setPhone(requestDTO.getPhone());
			customer.setStatus(Parameter.builder()
					.idParameter(requestDTO.getIdStatus())
					.build());
			
			CustomerDTO customerDTO = serviceSave.postData(customer, customerRepository, converter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.CUSTOMER, customerDTO);
		}

		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.CUSTOMER, errorList);
		
	}
}
