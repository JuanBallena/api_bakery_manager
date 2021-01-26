package com.pablo.bakeryManager.services.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ParameterConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.ParameterDTO;
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.params.ParameterParams;
import com.pablo.bakeryManager.repository.ParameterRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ResponseToFinder;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.Finder;

@Service
public class ParameterFinder {

	@Autowired
	private ParameterRepository parameterRepository;
	
	@Autowired
	private ParameterConverter parameterConverter;
	
	@Autowired
	private Finder<Parameter, ParameterDTO> finder;
	
	@Autowired
	private ResponseToFinder responseToFinder;
	
	public ServiceResponse getData(ParameterParams params) {
		
		PageResponse pageResponse = finder.getData(params, parameterRepository, parameterConverter);
		
		return responseToFinder.dispatch(ResponseTypeDefinition.PARAMETERS, pageResponse);
	}
}
