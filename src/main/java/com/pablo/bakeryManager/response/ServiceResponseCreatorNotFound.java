package com.pablo.bakeryManager.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseCreatorNotFound {

	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private ServiceResponseCreatorInternalServerError responseCreatorInternalServerError;
	
	private Integer STATUS_CODE    = 404;
	private String  STATUS_MESSAGE = "SIN CONTENIDO";
	
	public ServiceResponse build(String responseType) {
		
		try {
			serviceResponse.setType(responseType);
			serviceResponse.setStatusCode(STATUS_CODE);
			serviceResponse.setStatusMessage(STATUS_MESSAGE);
			
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseCreatorInternalServerError.build(responseType);
	}
}
