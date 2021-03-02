package com.pablo.bakeryManager.application.modules.product.productCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.exception.BadRequestExceptionHandler;
import com.pablo.bakeryManager.application.modules.product.ProductResponse;
import com.pablo.bakeryManager.application.modules.product.ProductResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseBadRequest;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseCreated;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.CommandHandler;
import com.pablo.bakeryManager.dominio.models.Product;

@Component
public class ProductCreatorCommandHandler implements CommandHandler<ProductCreatorCommand, ServiceResponse> {

	@Autowired
	private ProductCreator productCreator;
	
	@Autowired
	private ProductResponseConverter productResponseConverter;
	
	@Override
	public ServiceResponse handle(ProductCreatorCommand command) {
		
		try {
			
			ProductCreatorRequest request = ProductCreatorRequest.create(command.request);
			
			Product product = productCreator.create(request);
			
			ProductResponse productResponse = productResponseConverter.convert(product);
			
			return new ServiceResponseCreated(ResourceType.PRODUCT, productResponse);
			
		} catch (BadRequestExceptionHandler e) {
			return new ServiceResponseBadRequest(ResourceType.PRODUCT, e.exceptionInfo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}

}
