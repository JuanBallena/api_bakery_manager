package com.pablo.bakeryManager.application.modules.category.categoriesFinder;

import org.springframework.data.domain.Sort.Order;

import com.pablo.bakeryManager.application.criteria.filtering.Filter;
import com.pablo.bakeryManager.application.criteria.sorting.OrderCreator;
import com.pablo.bakeryManager.application.criteria.sorting.OrderTypes;
import com.pablo.bakeryManager.dominio.models.Category;
import com.pablo.bakeryManager.infrastructure.requestParams.CategoryRequestParams;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoriesFinderRequest {
	
	private Boolean visible;
	private String orderBy;
	private String orderType;
	private int page;
	private int size;
	
	public static final CategoriesFinderRequest create(CategoryRequestParams params) {
		
		return CategoriesFinderRequest.builder()
				.visible(params.visible)
				.orderBy(params.orderBy)
				.orderType(params.orderType)
				.page(params.page)
				.size(params.size)
				.build();
	}
	
	public Boolean visibleParameterIsValid() {
		
		return this.visible != null;
	}
	
	public Filter filterByVisible() {
		
		return new Filter(Category.VISIBLE, this.visible);
	}
	
	public Boolean orderByParameterIsValid() {
		
		return Category.allowedSorts.contains(orderBy);
	}
	
	public Boolean orderTypeParameterIsValid() {
		
		return OrderTypes.isAscOrDesc(this.orderType);
	}
	
	public Order order() {
		
		return OrderCreator.create(this.orderBy, this.orderType);
	}
}
