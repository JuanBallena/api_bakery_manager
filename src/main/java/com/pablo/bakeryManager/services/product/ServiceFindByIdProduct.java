package com.pablo.bakeryManager.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.ProductDTO;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindById;

@Service
public class ServiceFindByIdProduct {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindById<Product, ProductDTO> serviceFindById;
	
	public ServiceResponse getData(Long idProduct) {
		
		ProductDTO productDTO = serviceFindById.getData(idProduct, productRepository, productConverter);
		
		if (productDTO == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.PRODUCT, productDTO);
		}
		
		return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.PRODUCT, productDTO);
	}
}
