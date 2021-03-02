package com.pablo.bakeryManager.application.modules.customer.customerCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.DatabaseIntegrityExceptionHandler;
import com.pablo.bakeryManager.dominio.models.Customer;
import com.pablo.bakeryManager.infrastructure.repository.CustomerRepository;

@Service
public class CustomerCreator {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer create(CustomerCreatorRequest request) throws DatabaseIntegrityExceptionHandler {
		
		this.ensureCategoryNameIsUnique(request.getCustomerName().value());
		
		Customer customer = Customer.create(request.getCustomerName().value(), request.getCustomerPhone().value());
		
		customerRepository.save(customer);
		customerRepository.refresh(customer);
		
		return customer;
	}
	
	private void ensureCategoryNameIsUnique(String name) throws DatabaseIntegrityExceptionHandler {
		
		Customer customer = customerRepository.findByName(name);
		
		if (customer != null) {
			throw new DatabaseIntegrityExceptionHandler("name", ErrorMessage.exists(name));
		}
	}
}
