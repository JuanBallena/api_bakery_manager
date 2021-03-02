package com.pablo.bakeryManager.application.modules.category;

import lombok.Builder;

@Builder
public class CategoryResponse {

	public Long    id;
	public String  name;
	public Boolean visible;
}
