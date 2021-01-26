package com.pablo.bakeryManager.controller.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.setting.SettingFinder;

@RestController
public class SettingsGetController {

	@Autowired
	private SettingFinder settingFinder;
	
	@GetMapping("/settings")
	public ServiceResponse getSettings() {
		
		return settingFinder.getData();
	}
}
