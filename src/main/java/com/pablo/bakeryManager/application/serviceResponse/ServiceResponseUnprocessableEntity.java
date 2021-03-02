package com.pablo.bakeryManager.application.serviceResponse;

public class ServiceResponseUnprocessableEntity extends ServiceResponse {

	private static final Integer STATUS_CODE    = 422;
	private static final String  STATUS_MESSAGE = "Entidad no procesable, error semántico";
	
	public ServiceResponseUnprocessableEntity() {
		
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
	}
}
