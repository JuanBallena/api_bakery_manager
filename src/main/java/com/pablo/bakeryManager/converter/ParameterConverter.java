package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.response.ParameterDTO;
import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.model.Parameter;

@Component
public class ParameterConverter implements Converter<Parameter, ParameterDTO> {

	@Override
	public ParameterDTO toDTO(Parameter p) {
		
		return ParameterDTO.builder()
				.id(p.getIdParameter())
				.description(p.getDescription())
				.build();
	}

	@Override
	public List<ParameterDTO> toDTOList(List<Parameter> parameterList) {
		
		List<ParameterDTO> parameterDTOList = new ArrayList<ParameterDTO>();
		parameterList.forEach(parameter -> parameterDTOList.add(toDTO(parameter)));
		
		return parameterDTOList;
	}

}
