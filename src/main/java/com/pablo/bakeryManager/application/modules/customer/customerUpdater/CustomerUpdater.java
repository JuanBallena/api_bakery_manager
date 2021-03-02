package com.pablo.bakeryManager.application.modules.customer.customerUpdater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.DatabaseIntegrityExceptionHandler;
import com.pablo.bakeryManager.application.exception.ResourceNotFoundExceptionHandler;
import com.pablo.bakeryManager.application.modules.customer.customerFinder.CustomerFinder;
import com.pablo.bakeryManager.dominio.models.Customer;
import com.pablo.bakeryManager.dominio.models.Parameter;
import com.pablo.bakeryManager.infrastructure.repository.CustomerRepository;

@Service
public class CustomerUpdater {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerFinder customerFinder;

	public Customer update(Long idCustomer, CustomerUpdaterRequest request) throws DatabaseIntegrityExceptionHandler, ResourceNotFoundExceptionHandler {
		
		this.ensureCustomerNameIsUnique(request.getCustomerName().value(), idCustomer);
		
		Customer customer = customerFinder.find(idCustomer);
		
		customer.setName(request.getCustomerName().value());
		customer.setPhone(request.getCustomerPhone().value());
		customer.setStatus(Parameter.builder().idParameter(request.getCustomerIdStatus().value()).build());
		
		customerRepository.save(customer);
		customerRepository.refresh(customer);
		
		return customer;
	}
	
	private void ensureCustomerNameIsUnique(String name, Long idCustomer) throws DatabaseIntegrityExceptionHandler {
		
		Customer customer = customerRepository.findByName(name);
		
		if (customer != null) {
			
			if (customer.getIdCustomer() != idCustomer) {
				throw new DatabaseIntegrityExceptionHandler("name", ErrorMessage.exists(name));
			}
		}
	}
}
