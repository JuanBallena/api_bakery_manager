package com.pablo.bakeryManager.services.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.SettingConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.setting.RequestUpdateSettingDTO;
import com.pablo.bakeryManager.dto.response.SettingDTO;
import com.pablo.bakeryManager.model.Setting;
import com.pablo.bakeryManager.repository.SettingRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.response.ServiceResponseCreatorNotFound;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.services.DatabaseChecker;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class SettingUpdater {

	@Autowired
	private SettingRepository settingRepository;
	
	@Autowired
	private SettingConverter settingConverter;
	
	@Autowired
	private DatabaseChecker<Setting> databaseChecker;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Setting, SettingDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorNotFound serviceResponseCreatorNotFound;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse putData(Long idSetting, RequestUpdateSettingDTO requestDTO) {
		
		Setting setting = databaseChecker.check(idSetting, settingRepository);
		
		if (setting == null) {
			
			return serviceResponseCreatorNotFound.build(ResponseTypeDefinition.SETTING);
		}
		
		List<Object> errorListSetting =  validatorRequestDTO.validate(requestDTO);
		
		if (errorListSetting.isEmpty()) {
			
			SettingDTO settingDTO = this.saveData(setting, requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.SETTING, settingDTO);
		}

		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.SETTING, errorListSetting);
	}
	
	private SettingDTO saveData(Setting setting, RequestUpdateSettingDTO requestDTO) {
		
		setting.setValue(requestDTO.getValue());
		
		return creator.saveData(setting, settingRepository, settingConverter);
	}
}
