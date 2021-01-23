package com.pablo.bakeryManager.validator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.order.RequestCreateOrderDTO;

@Component
public class ValidatorRequestCreateOrderDTO {
	
	private static final String PROPERTY_NAME_FOR_ERRORS = "errorListOrderDetails";
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ValidatorMultipleRequestDTO validatorMultipleRequestDTO;

	public List<Object> validate(RequestCreateOrderDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (requestDTO.getOrderDetailList().isEmpty()) {
			
			return errorList;
		}
		
		Map<String, List<Object>> map = validatorMultipleRequestDTO.validate(PROPERTY_NAME_FOR_ERRORS, requestDTO.getOrderDetailList());
		
		if (map.get(PROPERTY_NAME_FOR_ERRORS).isEmpty()) {
			
			return errorList;
		}
		
		errorList.add(map);
		
		return errorList;
	}
}
