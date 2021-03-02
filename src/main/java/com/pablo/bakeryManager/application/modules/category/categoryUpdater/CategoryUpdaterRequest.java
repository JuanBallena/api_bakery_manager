package com.pablo.bakeryManager.application.modules.category.categoryUpdater;

import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;
import com.pablo.bakeryManager.application.modules.category.valueObject.CategoryName;
import com.pablo.bakeryManager.application.modules.category.valueObject.CategoryVisible;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateCategory;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryUpdaterRequest {

	private CategoryName categoryName;
	private CategoryVisible categoryVisible;
	
	public static final CategoryUpdaterRequest build(RequestUpdateCategory request) throws RequestBodyExceptionHandler {
		
		return CategoryUpdaterRequest.builder()
				.categoryName(new CategoryName(request.name))
				.categoryVisible(new CategoryVisible(request.visible))
				.build();
	}
}
