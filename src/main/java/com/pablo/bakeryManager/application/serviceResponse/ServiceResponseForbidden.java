package com.pablo.bakeryManager.application.serviceResponse;

public class ServiceResponseForbidden extends ServiceResponse {

	private static final Integer STATUS_CODE    = 403;
	private static final String  STATUS_MESSAGE = "Prohibido";
	
	public ServiceResponseForbidden() {
		
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
	}
}
