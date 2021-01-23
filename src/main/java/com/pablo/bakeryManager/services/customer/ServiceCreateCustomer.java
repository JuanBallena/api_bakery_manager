package com.pablo.bakeryManager.services.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ParameterDefinition;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.CustomerDTO;
import com.pablo.bakeryManager.dto.customer.RequestCreateCustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceCreateCustomer {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceSave<Customer, CustomerDTO> serviceSave;
	
	public ServiceResponse postData(RequestCreateCustomerDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			Customer customer = new Customer();
			customer.setName(requestDTO.getName());
			customer.setPhone(requestDTO.getPhone());
			customer.setStatus(Parameter.builder()
					.idParameter(ParameterDefinition.PARAMETER_ACTIVE)
					.build());
			
			CustomerDTO customerDTO = serviceSave.postData(customer, customerRepository, customerConverter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.CUSTOMER, customerDTO);
		}
			
		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.CUSTOMER, errorList);		
	}
}
