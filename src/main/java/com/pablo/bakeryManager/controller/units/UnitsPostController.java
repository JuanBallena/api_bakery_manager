package com.pablo.bakeryManager.controller.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.unit.RequestCreateUnitDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.unit.UnitCreator;

@RestController
public class UnitsPostController {

	@Autowired
	private UnitCreator unitCreator;
	
	@PostMapping("/units")
	public ServiceResponse saveUnit(@RequestBody RequestCreateUnitDTO requestDTO) {
		
		return unitCreator.postData(requestDTO);
	}
}
