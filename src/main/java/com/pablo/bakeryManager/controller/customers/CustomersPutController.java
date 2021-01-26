package com.pablo.bakeryManager.controller.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.customer.RequestUpdateCustomerDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.customer.CustomerUpdater;

@RestController
public class CustomersPutController {

	@Autowired
	private CustomerUpdater customerUpdater;
	
	@PutMapping("/customers/{idCustomer}")
	public ServiceResponse updateCustomer(@PathVariable("idCustomer") Long idCustomer, @RequestBody RequestUpdateCustomerDTO requestDTO) {
		
		return customerUpdater.putData(idCustomer, requestDTO);
	}
}
