package com.pablo.bakeryManager.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.RequestDTO;

@Component
public class ValidatorMultipleRequestDTO {
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;

	public Map<String, List<Object>> validate(String propertyName, List<? extends RequestDTO> requestDTOList) {
		
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		List<Object> errorList = new ArrayList<Object>();
		
		for (RequestDTO requestDTO : requestDTOList) {
			
			List<Object> errorRequestDTO = validatorRequestDTO.validate(requestDTO);
			
			if (errorRequestDTO.size() > 0) {
				errorList.add(errorRequestDTO);
			}
		}
		
		map.put(propertyName, errorList);
		return map;
	}
}
