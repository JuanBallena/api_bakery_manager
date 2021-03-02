package com.pablo.bakeryManager.application.serviceResponse;

public class ServiceResponseBadRequest extends ServiceResponse {
	
	public static final Integer STATUS_CODE    = 400;
	public static final String  STATUS_MESSAGE = "Solicitud incorrecta";
	
	public ServiceResponseBadRequest(String resourceType, Object error) {
	
		super.setResourceType(resourceType);
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
		super.setError(error);
	}	
}
