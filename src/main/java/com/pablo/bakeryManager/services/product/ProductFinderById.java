package com.pablo.bakeryManager.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.ProductDTO;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.response.ResponseToFinderById;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.FinderById;

@Service
public class ProductFinderById {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private FinderById<Product, ProductDTO> serviceFindById;
	
	@Autowired
	private ResponseToFinderById responseToFinderById;
	
	public ServiceResponse getData(Long idProduct) {
		
		ProductDTO productDTO = serviceFindById.getData(idProduct, productRepository, productConverter);
		
		return responseToFinderById.dispatch(ResponseTypeDefinition.PRODUCT, productDTO);
	}
}
