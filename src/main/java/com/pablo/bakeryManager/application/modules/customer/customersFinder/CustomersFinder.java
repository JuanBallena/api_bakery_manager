package com.pablo.bakeryManager.application.modules.customer.customersFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.criteria.paging.Pagination;
import com.pablo.bakeryManager.dominio.models.Customer;
import com.pablo.bakeryManager.infrastructure.generic.FindAllGeneric;
import com.pablo.bakeryManager.infrastructure.repository.CustomerRepository;

@Service
public class CustomersFinder {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private FindAllGeneric<Customer> findAllGeneric;
	
	public Pagination<Customer> find(CustomersFinderCriteria criteria) {
		
		return findAllGeneric.find(customerRepository, criteria);
	}
}
