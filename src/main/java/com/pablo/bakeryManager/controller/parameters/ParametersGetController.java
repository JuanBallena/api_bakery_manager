package com.pablo.bakeryManager.controller.parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.request.ParameterRequest;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.parameter.ServiceFindAllParameters;

@RestController
public class ParametersGetController {

	@Autowired
	private ServiceFindAllParameters serviceFindAllParameters;
	
	@GetMapping("/parameters")
	public ServiceResponse getParameters(ParameterRequest request) {
		
		return serviceFindAllParameters.getData(request);
	}
}
