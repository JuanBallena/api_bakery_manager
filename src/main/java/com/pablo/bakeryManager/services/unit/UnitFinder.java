package com.pablo.bakeryManager.services.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.UnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.params.UnitParams;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ResponseToFinder;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.Finder;

@Service
public class UnitFinder {
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter unitConverter;
	
	@Autowired
	private Finder<Unit, UnitDTO> finder;
	
	@Autowired
	private ResponseToFinder responseToFinder;
	
	public ServiceResponse getData(UnitParams params) {
		
		PageResponse pageResponse = finder.getData(params, unitRepository, unitConverter);
		
		return responseToFinder.dispatch(ResponseTypeDefinition.UNITS, pageResponse);
	}
}
