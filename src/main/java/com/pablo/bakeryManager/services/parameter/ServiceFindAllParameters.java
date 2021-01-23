package com.pablo.bakeryManager.services.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ParameterConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.ParameterDTO;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.repository.ParameterRepository;
import com.pablo.bakeryManager.request.ParameterRequest;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindAll;

@Service
public class ServiceFindAllParameters {

	@Autowired
	private ParameterRepository parameterRepository;
	
	@Autowired
	private ParameterConverter parameterConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindAll<Parameter, ParameterDTO> serviceFindAll;
	
	public ServiceResponse getData(ParameterRequest request) {
		
		PageResponse pageResponse = serviceFindAll.getData(request, parameterRepository, parameterConverter);
		
		if (pageResponse.hasData()) {
			
			return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.PARAMETERS, pageResponse);
		}
		
		return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.PARAMETERS, pageResponse);
	}
}
