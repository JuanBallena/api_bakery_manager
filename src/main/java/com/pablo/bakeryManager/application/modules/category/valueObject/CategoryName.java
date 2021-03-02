package com.pablo.bakeryManager.application.modules.category.valueObject;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;

public class CategoryName {
	
	private static final String FIELD_NAME = "name";
	private String value;
	
	public CategoryName(String name) throws RequestBodyExceptionHandler {
		
		this.ensureNameIsValid(name);
		this.value = name;
	}
	
	public String value() {
		return this.value;
	}
	
	private void ensureNameIsValid(String name) throws RequestBodyExceptionHandler {
		
		this.ensureNameIsNotNull(name);
		this.ensureNameIsNotEmpty(name);
		this.ensureNameHas3To50Characters(name);
	}
	
	private void ensureNameIsNotNull(String name) throws RequestBodyExceptionHandler{
		
		if (name == null) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.notNull);
		}
	}
	
	private void ensureNameIsNotEmpty(String name) throws RequestBodyExceptionHandler {
		
		if (name.replaceAll("\\s","").equals("")) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.notEmpty);
		}
	}

	private void ensureNameHas3To50Characters (String name) throws RequestBodyExceptionHandler {
		
		int min = 3;
		int max = 50;
		
		if (name.length() < min || name.length() > max) {
			throw new RequestBodyExceptionHandler(FIELD_NAME, ErrorMessage.size(min, max));
		}
	}
}
