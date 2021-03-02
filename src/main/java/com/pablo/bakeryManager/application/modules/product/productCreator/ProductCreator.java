package com.pablo.bakeryManager.application.modules.product.productCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.DatabaseIntegrityExceptionHandler;
import com.pablo.bakeryManager.dominio.models.Product;
import com.pablo.bakeryManager.infrastructure.repository.ProductRepository;

@Service
public class ProductCreator {

	@Autowired
	private ProductRepository productRepository;
	
	public Product create(ProductCreatorRequest request) throws DatabaseIntegrityExceptionHandler {
		
		this.ensureProductNameIsUnique(request.getProductName().value());
		
		Product product = Product.create(request.getProductIdCategory().value(), request.getProductName().value());
		
		productRepository.save(product);
		productRepository.refresh(product);
		
		return product;
	}
	
	private void ensureProductNameIsUnique(String name) throws DatabaseIntegrityExceptionHandler {
		
		Product product = productRepository.findByName(name);
		
		if (product != null) {
			throw new DatabaseIntegrityExceptionHandler("name", ErrorMessage.exists(name));
		}
	}
}
