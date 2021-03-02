package com.pablo.bakeryManager.application.modules.category.categoriesFinder;

import com.pablo.bakeryManager.application.criteria.CriteriaQuery;
import com.pablo.bakeryManager.dominio.models.Category;

public class CategoriesFinderCriteria extends CriteriaQuery<Category> {
				
	public CategoriesFinderCriteria(CategoriesFinderRequest request) {

		if (request.visibleParameterIsValid()) {
			this.filters.add(request.filterByVisible());
		}
		
		if (request.orderByParameterIsValid() & request.orderTypeParameterIsValid()) {
			this.orders.add(request.order());
		}
		
		this.page = request.getPage();
		this.size = request.getSize();
	}
}
