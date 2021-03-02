package com.pablo.bakeryManager.application.modules.product.productUpdater;

import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;
import com.pablo.bakeryManager.application.modules.product.valueObject.ProductIdCategory;
import com.pablo.bakeryManager.application.modules.product.valueObject.ProductName;
import com.pablo.bakeryManager.application.modules.product.valueObject.ProductVisible;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateProduct;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductUpdaterRequest {

	private ProductIdCategory productIdCategory;
	private ProductName productName;
	private ProductVisible productVisible;
	
	public static final ProductUpdaterRequest create(RequestUpdateProduct request) throws RequestBodyExceptionHandler {
		
		return ProductUpdaterRequest.builder()
				.productIdCategory(new ProductIdCategory(request.idCategory))
				.productName(new ProductName(request.name))
				.productVisible(new ProductVisible(request.visible))
				.build();
	}
}
