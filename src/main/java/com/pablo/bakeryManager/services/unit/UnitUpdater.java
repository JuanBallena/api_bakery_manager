package com.pablo.bakeryManager.services.unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.unit.RequestUpdateUnitDTO;
import com.pablo.bakeryManager.dto.response.UnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.response.ServiceResponseCreatorNotFound;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.services.DatabaseChecker;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class UnitUpdater {

	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter UnitConverter;
	
	@Autowired
	private DatabaseChecker<Unit> databaseChecker;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Unit, UnitDTO> serviceSave;
	
	@Autowired
	private ServiceResponseCreatorNotFound serviceResponseCreatorNotFound;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse putData(Long idUnit, RequestUpdateUnitDTO requestDTO) {
		
		Unit unit = databaseChecker.check(idUnit, unitRepository);
		
		if (unit == null) {
			
			return serviceResponseCreatorNotFound.build(ResponseTypeDefinition.UNIT);
		}
		
		List<Object> errorListUnit =  validatorRequestDTO.validate(requestDTO);
		
		if (errorListUnit.isEmpty()) {
			
			UnitDTO unitDTO = this.saveData(unit, requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.UNIT, unitDTO);
		}

		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.UNIT, errorListUnit);
	}
	
	private UnitDTO saveData(Unit unit, RequestUpdateUnitDTO requestDTO) {
		
		unit.setName(requestDTO.getName());
		unit.setVisible(requestDTO.getVisible());
		
		return serviceSave.saveData(unit, unitRepository, UnitConverter);
	}
}
