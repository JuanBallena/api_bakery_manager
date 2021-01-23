package com.pablo.bakeryManager.response;

import com.pablo.bakeryManager.interf.ResponseDTO;

public class ServiceResponseOk {

	public static final ServiceResponse create(String responseType, PageResponse pageResponse) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setType(responseType);
		
		try {
			serviceResponse.addResponseOk();
			serviceResponse.setData(pageResponse.getData());
			serviceResponse.setPages(pageResponse.getTotalPages());
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
	
	public static final ServiceResponse create(String serviceResponseType, ResponseDTO responseDTO) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setType(serviceResponseType);
		
		try {
			serviceResponse.addResponseOk();
			serviceResponse.setData(responseDTO);
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
}
