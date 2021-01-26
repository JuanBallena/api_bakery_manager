package com.pablo.bakeryManager.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.ResponseDTO;

@Component
public final class ResponseToFinderById {
	
	@Autowired
	private ServiceResponseCreatorNoContent serviceResponseCreatorNoContent;
	
	@Autowired
	private ServiceResponseCreatorOk serviceResponseCreatorOk;

	public ServiceResponse dispatch(String responseType, ResponseDTO responseDTO) {
		
		return (responseDTO == null)
				? serviceResponseCreatorNoContent.build(responseType, responseDTO)
				: serviceResponseCreatorOk.build(responseType, responseDTO);
	}
}
