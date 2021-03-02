package com.pablo.bakeryManager.application.modules.product.productCreator;

import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;
import com.pablo.bakeryManager.application.modules.product.valueObject.ProductIdCategory;
import com.pablo.bakeryManager.application.modules.product.valueObject.ProductName;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateProduct;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCreatorRequest {

	private ProductIdCategory productIdCategory;
	private ProductName productName;
	
	public static final ProductCreatorRequest create(RequestCreateProduct request) throws RequestBodyExceptionHandler {
		
		return ProductCreatorRequest.builder()
				.productIdCategory(new ProductIdCategory(request.idCategory))
				.productName(new ProductName(request.name))
				.build();
	}
}
