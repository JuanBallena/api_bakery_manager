package com.pablo.bakeryManager.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.ResponseDTO;

@Component
public class ServiceResponseCreatorOk {

	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private ServiceResponseCreatorInternalServerError serviceResponseCreatorInternalServerError;
	
	private Integer STATUS_CODE    = 200;
	private String  STATUS_MESSAGE = "OK";
	
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
		
		return serviceResponseCreatorInternalServerError.build(responseType);
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
		
		return serviceResponseCreatorInternalServerError.build(responseType);
	}
}
