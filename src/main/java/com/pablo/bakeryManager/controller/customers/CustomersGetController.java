package com.pablo.bakeryManager.controller.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.params.CustomerParams;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.customer.CustomerFinder;
import com.pablo.bakeryManager.services.customer.CustomerFinderById;


@RestController
public class CustomersGetController {

	@Autowired
	private CustomerFinder customerFinder;
	
	@Autowired
	private CustomerFinderById customerFinderById;
	
	
	@GetMapping("/customers")
	public ServiceResponse getCustomers(CustomerParams params) {

		return customerFinder.getData(params);
	}
	
	@GetMapping("/customers/{idCustomer}")
	public ServiceResponse getCustomer(@PathVariable("idCustomer") Long idCustomer) {
		
		return customerFinderById.getData(idCustomer);
	}
}
