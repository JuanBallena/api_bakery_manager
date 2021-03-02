package com.pablo.bakeryManager.application.modules.product.valueObject;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;

public class ProductName {

	private static final String FIELD_NAME = "name";
	private String value;
	
	public ProductName(String name) throws RequestBodyExceptionHandler {
		
		this.ensureProductNameIsValid(name);
		this.value = name;
	}
	
	public String value() {
		
		return value;
	}
	
	private void ensureProductNameIsValid(String name) throws RequestBodyExceptionHandler {
		
		this.ensureProductNameIsNotNull(name);
		this.ensureNameIsNotEmpty(name);
		this.ensureNameHas3To100Characters(name);
	}
	
	private void ensureProductNameIsNotNull(String name) throws RequestBodyExceptionHandler {
		
		if (name == null) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.notNull);
		}
	}
	
	private void ensureNameIsNotEmpty(String name) throws RequestBodyExceptionHandler {
		
		if (name.replaceAll("\\s","").equals("")) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.notEmpty);
		}
	}

	private void ensureNameHas3To100Characters (String name) throws RequestBodyExceptionHandler {
		
		int min = 3;
		int max = 100;
		
		if (name.length() < min || name.length() > max) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.size(min, max));
		}
	}
}
