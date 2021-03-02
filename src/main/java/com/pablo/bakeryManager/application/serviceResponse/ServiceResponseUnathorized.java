package com.pablo.bakeryManager.application.serviceResponse;

public class ServiceResponseUnathorized extends ServiceResponse {

	private static final Integer STATUS_CODE    = 401;
	private static final String  STATUS_MESSAGE = "No autorizado";
	
	public ServiceResponseUnathorized() {
		
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
	}
}
