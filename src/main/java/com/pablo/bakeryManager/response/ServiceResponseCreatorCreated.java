package com.pablo.bakeryManager.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.ResponseDTO;

@Component
public class ServiceResponseCreatorCreated {

	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private ServiceResponseCreatorInternalServerError serviceResponseCreatorInternalServerError;
	
	private Integer STATUS_CODE    = 201;
	private String  STATUS_MESSAGE = "GUARDADO CON EXITO";
	
	public ServiceResponse build(String responseType, ResponseDTO responseDTO) {
		
		try {
			serviceResponse.setType(responseType);
			serviceResponse.setStatusCode(STATUS_CODE);
			serviceResponse.setStatusMessage(STATUS_MESSAGE);
			serviceResponse.setData(responseDTO);
			
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return serviceResponseCreatorInternalServerError.build(responseType);
	}
}
