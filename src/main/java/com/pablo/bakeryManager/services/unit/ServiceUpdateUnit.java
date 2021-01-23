package com.pablo.bakeryManager.services.unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.UnitDTO;
import com.pablo.bakeryManager.dto.unit.RequestUpdateUnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceVerifyDB;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceUpdateUnit {

	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter UnitConverter;
	
	@Autowired
	private ServiceVerifyDB<Unit> serviceVerifyDB;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceSave<Unit, UnitDTO> serviceSave;
	
	public ServiceResponse putData(Long idUnit, RequestUpdateUnitDTO requestDTO) {
		
		Unit unit = serviceVerifyDB.check(idUnit, unitRepository);
		
		if (unit == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.UNIT);
		}
		
		List<Object> errorList =  validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			unit.setName(requestDTO.getName());
			unit.setVisible(requestDTO.getVisible());
			
			UnitDTO unitDTO = serviceSave.postData(unit, unitRepository, UnitConverter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.UNIT, unitDTO);
		}

		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.UNIT, errorList);
	}
}
