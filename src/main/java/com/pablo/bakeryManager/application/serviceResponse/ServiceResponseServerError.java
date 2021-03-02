package com.pablo.bakeryManager.application.serviceResponse;

public final class ServiceResponseServerError extends ServiceResponse {
	
	public static final Integer STATUS_CODE    = 500;
	public static final String  STATUS_MESSAGE = "Error de servidor";
	
	public ServiceResponseServerError() {
		
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
	}
}
