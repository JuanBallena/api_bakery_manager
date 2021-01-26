package com.pablo.bakeryManager.controller.parameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.params.ParameterParams;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.parameter.ParameterFinder;

@RestController
public class ParametersGetController {

	@Autowired
	private ParameterFinder parameterFinder;
	
	@GetMapping("/parameters")
	public ServiceResponse getParameters(ParameterParams params) {
		
		return parameterFinder.getData(params);
	}
}
