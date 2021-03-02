package com.pablo.bakeryManager.application.modules.product.productFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.exception.ResourceNotFoundExceptionHandler;
import com.pablo.bakeryManager.dominio.models.Product;
import com.pablo.bakeryManager.infrastructure.repository.ProductRepository;

@Service
public class ProductFinder {

	@Autowired
	private ProductRepository productRepository;
	
	public Product find(Long idProduct) throws ResourceNotFoundExceptionHandler {
		
		Product product = productRepository.findById(idProduct).orElse(null);
		
		this.ensureProductExisting(product);
		
		return product;
	}
	
	private void ensureProductExisting(Product product) throws ResourceNotFoundExceptionHandler {
		
		if (product == null) {
			throw new ResourceNotFoundExceptionHandler("Producto no existe");
		}
	}
}

