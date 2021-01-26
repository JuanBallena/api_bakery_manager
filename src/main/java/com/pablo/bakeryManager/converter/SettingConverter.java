package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.response.SettingDTO;
import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.model.Setting;

@Component
public class SettingConverter implements Converter<Setting, SettingDTO> {

	@Override
	public SettingDTO toDTO(Setting s) {
		
		return SettingDTO.builder()
				.id(s.getIdSetting())
				.name(s.getName())
				.description(s.getDescription())
				.value(s.getValue())
				.build();
	}

	@Override
	public List<SettingDTO> toDTOList(List<Setting> settingList) {
		
		List<SettingDTO> settingDTOList = new ArrayList<SettingDTO>();
		settingList.forEach(setting -> settingDTOList.add(toDTO(setting)));
		
		return settingDTOList;
	}

}
