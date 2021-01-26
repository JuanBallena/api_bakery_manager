package com.pablo.bakeryManager.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.ResponseDTO;

@Component
public final class ServiceResponseCreatorNoContent {
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private ServiceResponseCreatorInternalServerError responseCreatorInternalServerError;
	
	private Integer STATUS_CODE    = 204;
	private String  STATUS_MESSAGE = "SIN CONTENIDO";
	
	public ServiceResponse build(String responseType, PageResponse pageResponse) {
		
		try {
			serviceResponse.setType(responseType);
			serviceResponse.setStatusCode(STATUS_CODE);
			serviceResponse.setStatusMessage(STATUS_MESSAGE);
			serviceResponse.setData(pageResponse.getData());
			serviceResponse.setPages(pageResponse.getTotalPages());
			
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseCreatorInternalServerError.build(responseType);
	}
	
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
		
		return responseCreatorInternalServerError.build(responseType);
	}
}
