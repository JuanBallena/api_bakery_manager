package com.pablo.bakeryManager.application.modules.setting;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.dominio.models.Setting;

@Component
public class SettingResponseConverter extends ResponseConverter<Setting, SettingResponse>{

	@Override
	public SettingResponse convert(Setting setting) {
		
		return SettingResponse.builder()
				.id(setting.getIdSetting())
				.name(setting.getName())
				.description(setting.getDescription())
				.value(setting.getValue())
				.build();
	}
}
