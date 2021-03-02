package com.pablo.bakeryManager.application.modules.customer.customerFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.exception.ResourceNotFoundExceptionHandler;
import com.pablo.bakeryManager.dominio.models.Customer;
import com.pablo.bakeryManager.infrastructure.repository.CustomerRepository;

@Service
public class CustomerFinder {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer find(Long idCustomer) throws ResourceNotFoundExceptionHandler {
		
		Customer customer = customerRepository.findById(idCustomer).orElse(null);
		
		this.ensureCustomerExisting(customer);
		
		return customer;
	}
	
	private void ensureCustomerExisting(Customer customer) throws ResourceNotFoundExceptionHandler {
		
		if (customer == null) {
			throw new ResourceNotFoundExceptionHandler("Cliente no existe");
		}
	}
}
