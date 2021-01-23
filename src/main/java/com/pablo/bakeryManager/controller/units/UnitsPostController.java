package com.pablo.bakeryManager.controller.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.unit.RequestCreateUnitDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.unit.ServiceCreateUnit;

@RestController
public class UnitsPostController {

	@Autowired
	private ServiceCreateUnit serviceCreateUnit;
	
	@PostMapping("/units")
	public ServiceResponse saveUnit(@RequestBody RequestCreateUnitDTO requestDTO) {
		
		return serviceCreateUnit.postData(requestDTO);
	}
}
