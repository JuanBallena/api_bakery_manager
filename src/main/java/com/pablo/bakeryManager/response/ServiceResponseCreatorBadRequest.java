

package com.pablo.bakeryManager.response;

import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseCreatorBadRequest {

	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private ServiceResponseCreatorInternalServerError serviceResponseCreatorInternalServerError;
	
	private Integer STATUS_CODE    = 400;
	private String  STATUS_MESSAGE = "SOLICITUD INCORRECTA";
	
	public ServiceResponse build(String responseType, List<Object> errorList) {
		
		try {
			serviceResponse.setType(responseType);
			serviceResponse.setStatusCode(STATUS_CODE);
			serviceResponse.setStatusMessage(STATUS_MESSAGE);
			serviceResponse.setErrorList(errorList);
			
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return serviceResponseCreatorInternalServerError.build(responseType);
	}
	
//	public ServiceResponse build(String responseType, Map<String, List<Object>> map) {
//		
//		try {
//			serviceResponse.setType(responseType);
//			serviceResponse.setStatusCode(STATUS_CODE);
//			serviceResponse.setStatusMessage(STATUS_MESSAGE);
//			serviceResponse.setErrorList(map.get("multipleErrorList"));
//			
//			return serviceResponse;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return serviceResponseCreatorInternalServerError.build(responseType);
//	}
	
}
