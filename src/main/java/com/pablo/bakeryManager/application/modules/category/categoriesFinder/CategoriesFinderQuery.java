package com.pablo.bakeryManager.application.modules.category.categoriesFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.infrastructure.requestParams.CategoryRequestParams;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoriesFinderQuery implements Query {

	public CategoryRequestParams params;
}
