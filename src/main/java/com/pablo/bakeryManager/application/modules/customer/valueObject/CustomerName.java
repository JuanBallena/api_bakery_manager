package com.pablo.bakeryManager.application.modules.customer.valueObject;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;

public class CustomerName {

	private static final String FIELD_NAME = "name";
	private String value;
	
	public CustomerName(String name) throws RequestBodyExceptionHandler {
		
		this.ensureNameIsValid(name);
		this.value = name;
	}
	
	public String value() {
		
		return value;
	}
	
	private void ensureNameIsValid(String name) throws RequestBodyExceptionHandler {
		
		this.ensureNameIsNotNull(name);
		this.ensureNameIsNotEmpty(name);
		this.ensureNameHas3To30Characters(name);
	}
	
	private void ensureNameIsNotNull(String name) throws RequestBodyExceptionHandler {
		
		if (name == null) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.notNull);
		}
	}
	
	private void ensureNameIsNotEmpty(String name) throws RequestBodyExceptionHandler {
		
		if (name.replaceAll("\\s","").equals("")) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.notEmpty);
		}
	}

	private void ensureNameHas3To30Characters (String name) throws RequestBodyExceptionHandler {
		
		int min = 3;
		int max = 30;
		
		if (name.length() < min || name.length() > max) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.size(min, max));
		}
	}
}
