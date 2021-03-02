package com.pablo.bakeryManager.application.modules.category.valueObject;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;

public class CategoryVisible {

	private static final String FIELD_VISIBLE = "visible";
	private Boolean value;
	
	public CategoryVisible(Boolean visible) throws RequestBodyExceptionHandler {
		
		this.ensureVisibleIsValid(visible);
		this.value = visible;
	}
	
	public Boolean value() {
		
		return this.value;
	}
	
	private void ensureVisibleIsValid(Boolean visible) throws RequestBodyExceptionHandler {
		
		this.ensureVisibleIsNotNull(visible);
	}
	
	private void ensureVisibleIsNotNull(Boolean visible) throws RequestBodyExceptionHandler {
		
		if (visible == null) {
			throw new RequestBodyExceptionHandler(FIELD_VISIBLE, ErrorMessage.notNull);
		}
	}
}
