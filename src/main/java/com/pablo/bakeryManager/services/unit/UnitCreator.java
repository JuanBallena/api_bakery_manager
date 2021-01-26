package com.pablo.bakeryManager.services.unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.unit.RequestCreateUnitDTO;
import com.pablo.bakeryManager.dto.response.UnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class UnitCreator {

	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter unitConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Unit, UnitDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse postData(RequestCreateUnitDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			UnitDTO unitDTO = this.saveData(requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.UNIT, unitDTO);
		}
		
		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.UNIT, errorList);	
	}
	
	private UnitDTO saveData(RequestCreateUnitDTO requestDTO) {
		
		Unit unit = new Unit();
		unit.setName(requestDTO.getName());
		
		return creator.saveData(unit, unitRepository, unitConverter);
	}
}
