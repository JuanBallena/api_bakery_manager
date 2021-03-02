package com.pablo.bakeryManager.application.modules.category;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.dominio.models.Category;

@Component
public class CategoryResponseConverter extends ResponseConverter<Category, CategoryResponse> {

	@Override
	public CategoryResponse convert(Category category) {
		
		return CategoryResponse.builder()
				.id(category.getIdCategory())
				.name(category.getName())
				.visible(category.getVisible())
				.build();
	}
}
