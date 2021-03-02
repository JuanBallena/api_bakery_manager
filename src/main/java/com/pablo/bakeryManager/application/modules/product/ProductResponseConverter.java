package com.pablo.bakeryManager.application.modules.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.application.modules.category.CategoryResponseConverter;
import com.pablo.bakeryManager.dominio.models.Product;

@Component
public class ProductResponseConverter extends ResponseConverter<Product, ProductResponse> {
	
	@Autowired
	private CategoryResponseConverter categoryResponseConverter;

	@Override
	public ProductResponse convert(Product product) {
		
		return ProductResponse.builder()
				.id(product.getIdProduct())
				.category(categoryResponseConverter.convert(product.getCategory()))
				.name(product.getName())
				.visible(product.getVisible())
				.build();
	}
}
