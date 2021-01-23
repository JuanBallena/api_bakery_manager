package com.pablo.bakeryManager.services.unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.UnitDTO;
import com.pablo.bakeryManager.dto.unit.RequestCreateUnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceCreateUnit {

	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter unitConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceSave<Unit, UnitDTO> serviceSave;
	
	public ServiceResponse postData(RequestCreateUnitDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			Unit unit = new Unit();
			unit.setName(requestDTO.getName());
			
			UnitDTO unitDTO = serviceSave.postData(unit, unitRepository, unitConverter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.UNIT, unitDTO);
		}
		
		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.UNIT, errorList);	
	}
}
