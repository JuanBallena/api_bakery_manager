package com.pablo.bakeryManager.application.modules.product.productsFinder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.criteria.paging.Pagination;
import com.pablo.bakeryManager.application.modules.product.ProductResponse;
import com.pablo.bakeryManager.application.modules.product.ProductResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNoContent;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseOk;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;
import com.pablo.bakeryManager.dominio.models.Product;

@Component
public class ProductsFinderQueryHandler implements QueryHandler<ProductsFinderQuery, ServiceResponse> {

	@Autowired
	private ProductsFinder productsFinder;
	
	@Autowired
	private ProductResponseConverter productResponseConverter;
	
	@Override
	public ServiceResponse handle(ProductsFinderQuery query) {
		
		try {
			
			ProductsFinderCriteria criteria = new ProductsFinderCriteria(ProductsFinderRequest.create(query.params));
			
			Pagination<Product> pagination = productsFinder.find(criteria);
			
			if (pagination.hasData()) {
				
				List<ProductResponse> productsResponse = productResponseConverter.convertList(pagination.getData());
				
				return new ServiceResponseOk(ResourceType.PRODUCTS, productsResponse, pagination.getTotalPages());
			}
			
			return new ServiceResponseNoContent(ResourceType.PRODUCTS, pagination.getData());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
