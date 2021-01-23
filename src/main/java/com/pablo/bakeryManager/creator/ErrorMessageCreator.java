package com.pablo.bakeryManager.creator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.pablo.bakeryManager.interf.RequestDTO;

public class ErrorMessageCreator {

	public static final List<Object> builder(Set<ConstraintViolation<RequestDTO>> violations) {
		
		List<Object> errorsMessage = new ArrayList<Object>();
		
		violations.forEach(violation -> {
			
			Map<String, String> map = new HashMap<String, String>();
			
			if (violation.getPropertyPath().toString().contains("_")) {
				
				map.put(violation.getPropertyPath().toString().replaceAll("_", ""), violation.getMessage().toString());
				
			} else {
				
				map.put(violation.getPropertyPath().toString(), violation.getMessage().toString());
			}
			
			errorsMessage.add(map);
		});
		
		return errorsMessage;
	}
}
