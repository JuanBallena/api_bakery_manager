package com.pablo.bakeryManager.response;

import com.pablo.bakeryManager.interf.ResponseDTO;

public class ServiceResponseCreated {

	public static final ServiceResponse create(String responseType, ResponseDTO responseDTO) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setType(responseType);
		
		try {
			serviceResponse.addResponseCreated();
			serviceResponse.setData(responseDTO);
			return serviceResponse;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
}
