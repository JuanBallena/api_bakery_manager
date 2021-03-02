package com.pablo.bakeryManager.application.modules.category.categoryFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryFinderQuery implements Query {

	public Long idCategory;
}
