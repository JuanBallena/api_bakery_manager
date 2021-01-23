package com.pablo.bakeryManager.controller.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.unit.RequestUpdateUnitDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.unit.ServiceUpdateUnit;

@RestController
public class UnitsPutController {

	@Autowired
	private ServiceUpdateUnit serviceUpdateUnit;
	
	@PutMapping("/units/{idUnit}")
	public ServiceResponse updateUnit(@PathVariable("idUnit") Long idUnit, @RequestBody RequestUpdateUnitDTO requestDTO) {
		
		return serviceUpdateUnit.putData(idUnit, requestDTO);
	}
}
