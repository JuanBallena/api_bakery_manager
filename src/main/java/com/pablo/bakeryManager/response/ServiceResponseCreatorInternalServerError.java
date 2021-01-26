package com.pablo.bakeryManager.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseCreatorInternalServerError {
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	private Integer STATUS_CODE    = 500;
	private String  STATUS_MESSAGE = "INTERNAL SERVER ERROR";

	public ServiceResponse build(String responseType) {
		
		serviceResponse.setType(responseType);
		serviceResponse.setStatusCode(STATUS_CODE);
		serviceResponse.setStatusMessage(STATUS_MESSAGE);
		
		return serviceResponse;
	}
}
