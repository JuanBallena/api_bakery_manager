package com.pablo.bakeryManager.infrastructure.controller.customer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.customer.customerUpdater.CustomerUpdaterCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateCustomer;

@RestController
public class CustomerPutController extends ApiController {

	@PutMapping("/customers/{id}")
	public Response putCustomer(@PathVariable("id") Long idCustomer, @RequestBody RequestUpdateCustomer request) {
		
		return super.dispatch(new CustomerUpdaterCommand(idCustomer, request));
	}
}
