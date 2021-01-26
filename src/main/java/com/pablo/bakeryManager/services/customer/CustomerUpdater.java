package com.pablo.bakeryManager.services.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CustomerConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.customer.RequestUpdateCustomerDTO;
import com.pablo.bakeryManager.dto.response.CustomerDTO;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.CustomerRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.response.ServiceResponseCreatorNotFound;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.services.DatabaseChecker;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class CustomerUpdater {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter converter;
	
	@Autowired
	private DatabaseChecker<Customer> databaseChecker;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Customer, CustomerDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorNotFound serviceResponseCreatorNotFound;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse putData(Long idCustomer, RequestUpdateCustomerDTO requestDTO) {
		
		Customer customer = databaseChecker.check(idCustomer, customerRepository);
		
		if (customer == null) {
			
			return serviceResponseCreatorNotFound.build(ResponseTypeDefinition.CUSTOMER);
		}
		
		List<Object> errorListCustomer =  validatorRequestDTO.validate(requestDTO);
		
		if (errorListCustomer.isEmpty()) {
			
			CustomerDTO customerDTO = this.saveData(customer, requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.CUSTOMER, customerDTO);
		}

		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.CUSTOMER, errorListCustomer);
		
	}
	
	private CustomerDTO saveData(Customer customer, RequestUpdateCustomerDTO requestDTO) {
		
		customer.setName(requestDTO.getName());
		customer.setPhone(requestDTO.getPhone());
		customer.setStatus(Parameter.builder()
				.idParameter(requestDTO.getIdStatus())
				.build());
		
		return creator.saveData(customer, customerRepository, converter);
	}
}
