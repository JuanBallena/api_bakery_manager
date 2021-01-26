package com.pablo.bakeryManager.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.ProductDTO;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.params.ProductParams;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ResponseToFinder;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.Finder;

@Service
public class ProductFinder {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private Finder<Product, ProductDTO> finder;
	
	@Autowired
	private ResponseToFinder responseToFinder;
	
	public ServiceResponse getData(ProductParams params) {
		
		PageResponse pageResponse = finder.getData(params, productRepository, productConverter);
		
		return responseToFinder.dispatch(ResponseTypeDefinition.PRODUCTS, pageResponse);
	}
}
