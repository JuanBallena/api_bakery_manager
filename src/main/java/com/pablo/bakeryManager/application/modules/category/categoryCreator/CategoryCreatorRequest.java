package com.pablo.bakeryManager.application.modules.category.categoryCreator;

import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;
import com.pablo.bakeryManager.application.modules.category.valueObject.CategoryName;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateCategory;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryCreatorRequest {

	private CategoryName categoryName;
	
	public static final CategoryCreatorRequest build(RequestCreateCategory request) throws RequestBodyExceptionHandler {
	
		return CategoryCreatorRequest.builder()
				.categoryName(new CategoryName(request.name))
				.build();
	}
}
