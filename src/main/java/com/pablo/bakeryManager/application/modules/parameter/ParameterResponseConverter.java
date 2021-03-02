package com.pablo.bakeryManager.application.modules.parameter;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.dominio.models.Parameter;

@Component
public class ParameterResponseConverter extends ResponseConverter<Parameter, ParameterResponse> {

	@Override
	public ParameterResponse convert(Parameter parameter) {
		
		return ParameterResponse.builder()
				.id(parameter.getIdParameter())
				.description(parameter.getDescription())
				.build();
	}
}
