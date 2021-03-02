package com.pablo.bakeryManager.application.serviceResponse;

public final class ServiceResponseOk extends ServiceResponse {
	
	public static final Integer STATUS_CODE    = 200;
	public static final String  STATUS_MESSAGE = "Exito";
	
	public ServiceResponseOk(String resourceType, Object data, int pages) {
	
		super.setResourceType(resourceType);
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
		super.setData(data);
		super.setPages(pages);
	}
	
	public ServiceResponseOk(String resourceType, Object data) {
		
		super.setResourceType(resourceType);
		super.setStatusCode(STATUS_CODE);
		super.setStatusMessage(STATUS_MESSAGE);
		super.setData(data);			
	}
}
