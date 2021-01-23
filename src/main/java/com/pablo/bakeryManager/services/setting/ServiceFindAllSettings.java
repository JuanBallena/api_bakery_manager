package com.pablo.bakeryManager.services.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.SettingConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.model.Setting;
import com.pablo.bakeryManager.repository.SettingRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;

@Service
public class ServiceFindAllSettings {

	@Autowired
	private SettingRepository settingRepository;
	
	@Autowired
	private SettingConverter settingConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	public ServiceResponse getData() {
		
		List<Setting> settingList = settingRepository.findAll();
		
		PageResponse pageResponse = new PageResponse();
		pageResponse.setData(settingConverter.toDTOList(settingList));
		pageResponse.setTotalPages(settingList.size() == 0 ? 0 : 1);
		
		if (pageResponse.hasData()) {
			
			return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.SETTINGS, pageResponse);
		}
		
		return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.SETTINGS, pageResponse); 
	}
}
