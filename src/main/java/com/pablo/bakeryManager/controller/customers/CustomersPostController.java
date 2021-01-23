package com.pablo.bakeryManager.controller.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.customer.RequestCreateCustomerDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.customer.ServiceCreateCustomer;

@RestController
public class CustomersPostController {

	@Autowired
	private ServiceCreateCustomer serviceCreateCustomer;

	@PostMapping("/customers")
	public ServiceResponse saveCustomer(@RequestBody RequestCreateCustomerDTO requestDTO) {
		
		return serviceCreateCustomer.postData(requestDTO);
	}
}
