package com.pablo.bakeryManager.application.modules.product.productsFinder;

import com.pablo.bakeryManager.application.criteria.CriteriaQuery;
import com.pablo.bakeryManager.dominio.models.Product;

public class ProductsFinderCriteria extends CriteriaQuery<Product> {

	public ProductsFinderCriteria(ProductsFinderRequest request) {
		
		if (request.idCategoryParameterIsValid()) {
			this.filters.add(request.filterByCategory());
		}
		
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
