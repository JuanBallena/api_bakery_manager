package com.pablo.bakeryManager.controller.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.setting.ServiceFindAllSettings;

@RestController
public class SettingsGetController {

	@Autowired
	private ServiceFindAllSettings serviceFindAllSettings;
	
	@GetMapping("/settings")
	public ServiceResponse getSettings() {
		
		return serviceFindAllSettings.getData();
	}
}
