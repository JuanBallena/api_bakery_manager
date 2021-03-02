package com.pablo.bakeryManager.infrastructure.controller.unit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.unit.unitsFinder.UnitsFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestParams.UnitRequestParams;

@RestController
public class UnitsGetController extends ApiController {
	
	@GetMapping("/units")
	public Response getUnits(UnitRequestParams request) {
		
		return super.ask(new UnitsFinderQuery(request));
	}
}
