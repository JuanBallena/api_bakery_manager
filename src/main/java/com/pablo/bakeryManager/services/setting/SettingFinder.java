package com.pablo.bakeryManager.services.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.SettingConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.model.Setting;
import com.pablo.bakeryManager.repository.SettingRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ResponseToFinder;
import com.pablo.bakeryManager.response.ServiceResponse;

@Service
public class SettingFinder {

	@Autowired
	private SettingRepository settingRepository;
	
	@Autowired
	private SettingConverter settingConverter;
	
	@Autowired
	private ResponseToFinder responseToFinder;

	public ServiceResponse getData() {
		
		List<Setting> settingList = settingRepository.findAll();
		
		PageResponse pageResponse = new PageResponse();
		pageResponse.setData(settingConverter.toDTOList(settingList));
		pageResponse.setTotalPages(settingList.size() == 0 ? 0 : 1);
		
		return responseToFinder.dispatch(ResponseTypeDefinition.SETTINGS, pageResponse); 
	}
}
