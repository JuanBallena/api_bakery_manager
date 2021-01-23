package com.pablo.bakeryManager.services.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.SettingConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.SettingDTO;
import com.pablo.bakeryManager.dto.setting.RequestUpdateSettingDTO;
import com.pablo.bakeryManager.model.Setting;
import com.pablo.bakeryManager.repository.SettingRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceVerifyDB;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceUpdateSetting {

	@Autowired
	private SettingRepository settingRepository;
	
	@Autowired
	private SettingConverter settingConverter;
	
	@Autowired
	private ServiceVerifyDB<Setting> serviceVerifyDB;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceSave<Setting, SettingDTO> serviceSave;
	
	public ServiceResponse putData(Long idSetting, RequestUpdateSettingDTO requestDTO) {
		
		Setting setting = serviceVerifyDB.check(idSetting, settingRepository);
		
		if (setting == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.SETTING);
		}
		
		List<Object> errorList =  validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			setting.setValue(requestDTO.getValue());
			
			SettingDTO settingDTO = serviceSave.postData(setting, settingRepository, settingConverter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.SETTING, settingDTO);
		}

		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.SETTING, errorList);
		
	}
}
