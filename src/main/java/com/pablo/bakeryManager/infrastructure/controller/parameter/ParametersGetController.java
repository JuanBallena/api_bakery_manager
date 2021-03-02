package com.pablo.bakeryManager.infrastructure.controller.parameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.parameter.parametersFinder.ParametersFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestParams.ParameterRequestParams;

@RestController
public class ParametersGetController extends ApiController {
	
	@GetMapping("/parameters")
	public Response getParameters(ParameterRequestParams request) {
		
		return super.ask(new ParametersFinderQuery(request));
	}
}
