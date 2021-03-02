package com.pablo.bakeryManager.infrastructure.controller.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.customer.customerCreator.CustomerCreatorCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateCustomer;

@RestController
public class CustomerPostController extends ApiController {
	
	@PostMapping("/customers")
	public Response postCustomer(@RequestBody RequestCreateCustomer request) {
		
		return super.dispatch(new CustomerCreatorCommand(request));
	}
}
