package com.pablo.bakeryManager.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.UniqueDataValidator;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.repository.CustomerRepository;

@Component
public class ValidatorUniqueCustomer implements UniqueDataValidator {
	
	private Validator validator = new Validator();
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean isValidToCreate(String propertyClass, Object value) {
		
		Customer customer = findCustomer(propertyClass, value);
		return validator.isNull(customer);
	}

	@Override
	public boolean isValidToUpdate(String propertyClass, Object value, Long id) {
		
		Customer customer = findCustomer(propertyClass, value);
		
		if (validator.notNull(customer)) {
			
			return customer.getIdCustomer().equals(id);
		}
		return true;	
	}
	
	private Customer findCustomer(String propertyClass, Object value) {
		
		switch (propertyClass) {
			case Customer.NAME:
				return customerRepository.findByName(value.toString());
			default:
				return null;
		}
	}
}
