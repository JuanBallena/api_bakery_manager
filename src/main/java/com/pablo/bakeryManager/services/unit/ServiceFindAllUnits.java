package com.pablo.bakeryManager.services.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.UnitConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.UnitDTO;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;
import com.pablo.bakeryManager.request.UnitRequest;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindAll;

@Service
public class ServiceFindAllUnits {
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitConverter unitConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindAll<Unit, UnitDTO> serviceFindAll;
	
	public ServiceResponse getData(UnitRequest request) {
		
		PageResponse pageResponse = serviceFindAll.getData(request, unitRepository, unitConverter);
		
		if (pageResponse.hasData()) {
			
			return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.UNITS, pageResponse);
		}
		
		return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.UNITS, pageResponse);
	}
}
