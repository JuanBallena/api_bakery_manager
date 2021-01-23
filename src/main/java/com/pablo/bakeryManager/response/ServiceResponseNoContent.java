package com.pablo.bakeryManager.response;

import com.pablo.bakeryManager.interf.ResponseDTO;

public class ServiceResponseNoContent {

	public static final ServiceResponse create(String responseType, PageResponse pageResponse) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setType(responseType);
		
		try {
			serviceResponse.setData(pageResponse.getData());
			serviceResponse.addResponseNoContent();
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
	
	public static final ServiceResponse create(String responseType, ResponseDTO responseDTO) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setType(responseType);
		
		try {
			serviceResponse.addResponseNoContent();
			serviceResponse.setData(responseDTO);
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
	
	public static final ServiceResponse create(String responseType) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setType(responseType);
		
		try {
			serviceResponse.addResponseNoContent();
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
}
