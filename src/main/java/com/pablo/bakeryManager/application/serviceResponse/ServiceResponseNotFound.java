package com.pablo.bakeryManager.application.serviceResponse;

public final class ServiceResponseNotFound extends ServiceResponse {
	
	private static final Integer STATUS_CODE    = 404;
	private static final String  STATUS_MESSAGE = "Recurso no encontrado";
	
	public ServiceResponseNotFound(String resourceType, Object error) {
		
		super.setResourceType(resourceType);
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
		super.setError(error);
	}
}
