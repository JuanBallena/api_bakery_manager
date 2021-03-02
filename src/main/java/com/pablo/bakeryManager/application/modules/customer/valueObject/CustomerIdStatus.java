package com.pablo.bakeryManager.application.modules.customer.valueObject;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;

public class CustomerIdStatus {

	private static final String FIELD_ID_STATUS = "idStatus";
	private Long value;
	
	public CustomerIdStatus(Integer idStatus) throws RequestBodyExceptionHandler {
		
		this.ensureIdStatusIsValid(idStatus);
		this.value = Long.valueOf(idStatus);
	}
	
	public Long value() {
		
		return this.value;
	}
	
	public void ensureIdStatusIsValid(Integer idStatus) throws RequestBodyExceptionHandler {
		
		this.ensureIdStatusIsNotNull(idStatus);
		this.ensureIdStatusIsPositive(idStatus);
	}
	
	private void ensureIdStatusIsNotNull(Integer idStatus) throws RequestBodyExceptionHandler {
		
		if (idStatus == null) {
			throw new RequestBodyExceptionHandler(FIELD_ID_STATUS, ErrorMessage.notNull);
		}
	}

	public void ensureIdStatusIsPositive(Integer idStatus) throws RequestBodyExceptionHandler {
		
		if (idStatus < 1) {
			throw new RequestBodyExceptionHandler(FIELD_ID_STATUS, ErrorMessage.positive);
		}
	}
}
