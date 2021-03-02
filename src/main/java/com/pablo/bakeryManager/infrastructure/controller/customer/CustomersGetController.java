package com.pablo.bakeryManager.infrastructure.controller.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.customer.customersFinder.CustomersFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestParams.CustomerRequestParams;

@RestController
public class CustomersGetController extends ApiController {
	
	@GetMapping("/customers")
	public Response getCustomers(CustomerRequestParams params) {
		
		return super.ask(new CustomersFinderQuery(params));
	}
}
