package com.pablo.bakeryManager.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.ProductDTO;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.request.ProductRequest;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindAll;

@Service
public class ServiceFindAllProducts {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter converter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindAll<Product, ProductDTO> serviceFindAll;
	
	public ServiceResponse getData(ProductRequest request) {
		
		PageResponse pageResponse = serviceFindAll.getData(request, productRepository, converter);
		
		if (pageResponse.hasData()) {
			
			return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.PRODUCTS, pageResponse);
		}
		
		return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.PRODUCTS, pageResponse);
	}
}
