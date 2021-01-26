package com.pablo.bakeryManager.controller.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.params.UnitParams;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.unit.UnitFinder;
import com.pablo.bakeryManager.services.unit.UnitFinderById;

@RestController
public class UnitsGetController {

	@Autowired
	private UnitFinder unitFinder;
	
	@Autowired
	private UnitFinderById unitFinderById;
	
	@GetMapping("/units")
	public ServiceResponse getUnits(UnitParams params) {
		
		return unitFinder.getData(params);
	}
	
	@GetMapping("/units/{idUnit}")
	public ServiceResponse getUnit(@PathVariable("idUnit") Long idUnit) {
		
		return unitFinderById.getData(idUnit);
	}
}
