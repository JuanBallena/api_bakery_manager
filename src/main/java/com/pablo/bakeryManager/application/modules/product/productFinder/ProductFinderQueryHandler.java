package com.pablo.bakeryManager.application.modules.product.productFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.exception.BadRequestExceptionHandler;
import com.pablo.bakeryManager.application.exception.NotFoundExceptionHandler;
import com.pablo.bakeryManager.application.modules.Id;
import com.pablo.bakeryManager.application.modules.product.ProductResponse;
import com.pablo.bakeryManager.application.modules.product.ProductResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseBadRequest;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNotFound;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseOk;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;
import com.pablo.bakeryManager.dominio.models.Product;

@Component
public class ProductFinderQueryHandler implements QueryHandler<ProductFinderQuery, ServiceResponse> {

	@Autowired
	private ProductFinder productFinder;
	
	@Autowired
	private ProductResponseConverter productResponseConverter;
	
	@Override
	public ServiceResponse handle(ProductFinderQuery query) {
		
		try {
			
			Id id = new Id(query.idProduct);
			
			Product product = productFinder.find(id.value());
			
			ProductResponse productResponse = productResponseConverter.convert(product);
			
			return new ServiceResponseOk(ResourceType.PRODUCT, productResponse);
		
		} catch(BadRequestExceptionHandler e){
			return new ServiceResponseBadRequest(ResourceType.PRODUCT, e.exceptionInfo());
		
		} catch(NotFoundExceptionHandler e){
			return new ServiceResponseNotFound(ResourceType.PRODUCT, e.exceptionInfo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
