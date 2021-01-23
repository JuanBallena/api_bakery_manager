package com.pablo.bakeryManager.creator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.ResponseDTO;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreated;
import com.pablo.bakeryManager.response.ServiceResponseNoContent;
import com.pablo.bakeryManager.response.ServiceResponseOk;

@Component
public class ServiceResponseCreator {

	public ServiceResponse createResponseOk(String responseType, PageResponse pageResponse) {
		
		return ServiceResponseOk.create(responseType, pageResponse);
	}
	
	public ServiceResponse createResponseOk(String responseType, ResponseDTO responseDTO) {
		
		return ServiceResponseOk.create(responseType, responseDTO);
	}
	
	public ServiceResponse createResponseCreated(String responseType, ResponseDTO responseDTO) {
		
		return ServiceResponseCreated.create(responseType, responseDTO);
	}
	
	public ServiceResponse createResponseNoContent(String responseType, PageResponse pageResponse) {
		
		return ServiceResponseNoContent.create(responseType, pageResponse);
	}
	
	public ServiceResponse createResponseNoContent(String responseType, ResponseDTO responseDTO) {
		
		return ServiceResponseNoContent.create(responseType, responseDTO);
	}
	
	public ServiceResponse createResponseNoContent(String responseType) {
		
		return ServiceResponseNoContent.create(responseType);
	}
	
	public ServiceResponse createResponseBadRequest(String responseType, List<Object> errorList) {
		
		return ServiceResponseBadRequest.create(responseType, errorList);
	}
}
