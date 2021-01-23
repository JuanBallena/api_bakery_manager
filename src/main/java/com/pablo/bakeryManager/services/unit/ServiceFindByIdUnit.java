package com.pablo.bakeryManager.services.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.UnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindById;

@Service
public class ServiceFindByIdUnit {
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter unitConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindById<Unit, UnitDTO> genericFindById;
	
	public ServiceResponse getData(Long idUnit) {
		
		UnitDTO unitDTO = genericFindById.getData(idUnit, unitRepository, unitConverter);
		
		if (unitDTO == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.UNIT, unitDTO);
		}
		
		return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.UNIT, unitDTO);
	}
}
