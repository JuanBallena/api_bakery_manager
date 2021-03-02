package com.pablo.bakeryManager.application.modules.product;

import com.pablo.bakeryManager.application.modules.category.CategoryResponse;

import lombok.Builder;

@Builder
public class ProductResponse {

	public Long             id;
	public CategoryResponse category;
	public String           name;
	public Boolean          visible;
}
