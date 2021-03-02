package com.pablo.bakeryManager.infrastructure.controller.unit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.unit.unitFinder.UnitFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;

@RestController
public class UnitGetController extends ApiController {
	
	@GetMapping("/units/{id}")
	public Response getUnit(@PathVariable("id") Long idUnit) {
		
		return super.ask(new UnitFinderQuery(idUnit));
	}
}
