package com.pablo.bakeryManager.infrastructure.controller.unit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.unit.unitCreator.UnitCreatorCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateUnit;

@RestController
public class UnitPostController extends ApiController {

	@PostMapping("/units")
	public Response postUnit(@RequestBody RequestCreateUnit request) {
		
		return super.dispatch(new UnitCreatorCommand(request));
	}
}
