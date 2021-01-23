package com.pablo.bakeryManager.controller.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.request.CustomerRequest;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.customer.ServiceFindAllCustomers;
import com.pablo.bakeryManager.services.customer.ServiceFindByIdCustomer;


@RestController
public class CustomersGetController {

	@Autowired
	private ServiceFindAllCustomers serviceFindAllCustomers;
	
	@Autowired
	private ServiceFindByIdCustomer serviceFindByIdCustomer;
	
	
	@GetMapping("/customers")
	public ServiceResponse getCustomers(CustomerRequest request) {

		return serviceFindAllCustomers.getData(request);
	}
	
	@GetMapping("/customers/{idCustomer}")
	public ServiceResponse getCustomer(@PathVariable("idCustomer") Long idCustomer) {
		
		return serviceFindByIdCustomer.getData(idCustomer);
	}
}
