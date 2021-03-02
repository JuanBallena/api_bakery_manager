package com.pablo.bakeryManager.application.serviceResponse;

public class ServiceResponseCreated extends ServiceResponse {
	
	public static final Integer STATUS_CODE    = 201;
	public static final String  STATUS_MESSAGE = "Guardado con éxito";
	
	public ServiceResponseCreated(String resourceType, Object data) {
	
		super.setResourceType(resourceType);
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
		super.setData(data);
	}
}
