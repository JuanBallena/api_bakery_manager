package com.pablo.bakeryManager.creator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.RequestDTO;

@Component
public class ErrorListCreator {

	public List<Object> build(Set<ConstraintViolation<RequestDTO>> violations) {
		
		List<Object> errorList = new ArrayList<Object>();
		
		violations.forEach(violation -> {
			
			Map<String, String> map = new HashMap<String, String>();
			
			if (violation.getPropertyPath().toString().contains("_")) {
				
				map.put(violation.getPropertyPath().toString().replaceAll("_", ""), violation.getMessage().toString());
				
			} else {
				
				map.put(violation.getPropertyPath().toString(), violation.getMessage().toString());
			}
			
			errorList.add(map);
		});
		
		return errorList;
	}
}
