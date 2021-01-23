package com.pablo.bakeryManager.controller.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.request.UnitRequest;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.unit.ServiceFindAllUnits;
import com.pablo.bakeryManager.services.unit.ServiceFindByIdUnit;

@RestController
public class UnitsGetController {

	@Autowired
	private ServiceFindAllUnits serviceFindAllUnits;
	
	@Autowired
	private ServiceFindByIdUnit serviceFindByIdUnit;
	
	@GetMapping("/units")
	public ServiceResponse getUnits(UnitRequest request) {
		
		return serviceFindAllUnits.getData(request);
	}
	
	@GetMapping("/units/{idUnit}")
	public ServiceResponse getUnit(@PathVariable("idUnit") Long idUnit) {
		
		return serviceFindByIdUnit.getData(idUnit);
	}
}
