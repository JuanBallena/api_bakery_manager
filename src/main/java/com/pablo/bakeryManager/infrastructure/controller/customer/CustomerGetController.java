package com.pablo.bakeryManager.infrastructure.controller.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.customer.customerFinder.CustomerFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;

@RestController
public class CustomerGetController extends ApiController {
	
	@GetMapping("/customers/{id}")
	public Response getCustomer(@PathVariable("id") Long idCustomer) {
		
		return super.ask(new CustomerFinderQuery(idCustomer));
	}
}
