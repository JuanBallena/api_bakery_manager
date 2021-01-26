package com.pablo.bakeryManager.services.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.definition.ParameterDefinition;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.customer.RequestCreateCustomerDTO;
import com.pablo.bakeryManager.dto.response.CustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class CustomerCreator {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Customer, CustomerDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse postData(RequestCreateCustomerDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			CustomerDTO customerDTO = this.saveData(requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.CUSTOMER, customerDTO);
		}
			
		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.CUSTOMER, errorList);		
	}
	
	private CustomerDTO saveData(RequestCreateCustomerDTO requestDTO) {
		
		Customer customer = new Customer();
		customer.setName(requestDTO.getName());
		customer.setPhone(requestDTO.getPhone());
		customer.setStatus(Parameter.builder().idParameter(ParameterDefinition.PARAMETER_ACTIVE).build());
		
		return creator.saveData(customer, customerRepository, customerConverter);
	}
}
