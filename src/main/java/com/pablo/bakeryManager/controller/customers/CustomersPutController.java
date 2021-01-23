package com.pablo.bakeryManager.controller.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.customer.RequestUpdateCustomerDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.customer.ServiceUpdateCustomer;

@RestController
public class CustomersPutController {

	@Autowired
	private ServiceUpdateCustomer serviceUpdateCustomer;
	
	@PutMapping("/customers/{idCustomer}")
	public ServiceResponse updateCustomer(@PathVariable("idCustomer") Long idCustomer, @RequestBody RequestUpdateCustomerDTO requestDTO) {
		
		return serviceUpdateCustomer.putData(idCustomer, requestDTO);
	}
}
