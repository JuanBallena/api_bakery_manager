package com.pablo.bakeryManager.services.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.UnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.response.ResponseToFinderById;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.FinderById;

@Service
public class UnitFinderById {
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter unitConverter;
	
	@Autowired
	private FinderById<Unit, UnitDTO> genericFindById;
	
	@Autowired
	private ResponseToFinderById responseToFinderById;
	
	public ServiceResponse getData(Long idUnit) {
		
		UnitDTO unitDTO = genericFindById.getData(idUnit, unitRepository, unitConverter);
		
		return responseToFinderById.dispatch(ResponseTypeDefinition.UNIT, unitDTO);
	}
}
