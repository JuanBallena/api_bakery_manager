package com.pablo.bakeryManager.application.modules.product.valueObject;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;

public class ProductIdCategory {

	private static final String FIELD_ID_CATEGORY = "idCategory";
	private Long value;
	
	public ProductIdCategory(Integer idCategory) throws RequestBodyExceptionHandler {
		
		this.ensureIdCategoryIsValid(idCategory);
		this.value = Long.valueOf(idCategory);
	}
	
	public Long value() {
		
		return this.value;
	}
	
	public void ensureIdCategoryIsValid(Integer idCategory) throws RequestBodyExceptionHandler {
		
		this.ensureIdCategoryIsNotNull(idCategory);
		this.ensureIdCategoryIsPositive(idCategory);
	}
	
	private void ensureIdCategoryIsNotNull(Integer idCategory) throws RequestBodyExceptionHandler {
		
		if (idCategory == null) {
			throw new RequestBodyExceptionHandler(FIELD_ID_CATEGORY, ErrorMessage.notNull);
		}
	}

	public void ensureIdCategoryIsPositive(Integer idCategory) throws RequestBodyExceptionHandler {
		
		if (idCategory < 1) {
			throw new RequestBodyExceptionHandler(FIELD_ID_CATEGORY, ErrorMessage.positive);
		}
	}
}
