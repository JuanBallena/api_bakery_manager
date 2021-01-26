package com.pablo.bakeryManager.controller.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.setting.RequestUpdateSettingDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.setting.SettingUpdater;

@RestController
public class SettingsPutController {

	@Autowired
	private SettingUpdater settingUpdater;
	
	@PutMapping("/settings/{idSetting}")
	public ServiceResponse updateSetting(@PathVariable("idSetting") Long idSetting, @RequestBody RequestUpdateSettingDTO requestDTO) {
		
		return settingUpdater.putData(idSetting, requestDTO);
	}
}
