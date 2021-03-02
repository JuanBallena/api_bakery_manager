package com.pablo.bakeryManager.application.serviceResponse;

public final class ServiceResponseNoContent extends ServiceResponse {
	
	public static final Integer STATUS_CODE    = 204;
	public static final String  STATUS_MESSAGE = "Sin contenido";
	
	public ServiceResponseNoContent(String resourceType, Object data) {
		
		super.setResourceType(resourceType);
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
		super.setData(data);
	}
}
