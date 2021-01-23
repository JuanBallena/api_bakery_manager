package com.pablo.bakeryManager.response;

import java.util.List;

public class ServiceResponseBadRequest {

	public static final ServiceResponse create(String responseType, List<Object> errorList) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setType(responseType);
		
		try {
			serviceResponse.addResponseBadRequest();
			serviceResponse.setErrorList(errorList);
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
}
