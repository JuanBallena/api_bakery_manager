package com.pablo.bakeryManager.application.modules.product.productsFinder;

import org.springframework.data.domain.Sort.Order;

import com.pablo.bakeryManager.application.criteria.filtering.Filter;
import com.pablo.bakeryManager.application.criteria.sorting.OrderCreator;
import com.pablo.bakeryManager.application.criteria.sorting.OrderTypes;
import com.pablo.bakeryManager.dominio.models.Product;
import com.pablo.bakeryManager.infrastructure.requestParams.ProductRequestParams;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductsFinderRequest {

	private Long idCategory;
	private Boolean visible;
	private String orderBy;
	private String orderType;
	private int page;
	private int size;
	
	public static final ProductsFinderRequest create(ProductRequestParams params) {
		
		return ProductsFinderRequest.builder()
				.idCategory(params.idCategory)
				.visible(params.visible)
				.orderBy(params.orderBy)
				.orderType(params.orderType)
				.page(params.page)
				.size(params.size)
				.build();
	}
	
	public Boolean idCategoryParameterIsValid() {
		
		return this.idCategory > 0;
	}
	
	public Filter filterByCategory() {
		
		return new Filter(Product.CATEGORY, this.idCategory);
	}
	
	public Boolean visibleParameterIsValid() {
		
		return this.visible != null;
	}
	
	public Filter filterByVisible() {
		
		return new Filter(Product.VISIBLE, this.visible);
	}
	
	public Boolean orderByParameterIsValid() {
		
		return Product.allowedSorts.contains(this.orderBy);
	}
	
	public Boolean orderTypeParameterIsValid() {
		
		return OrderTypes.isAscOrDesc(this.orderType);
	}
	
	public Order order() {
		
		return OrderCreator.create(this.orderType, this.orderBy);
	}
}
