package com.pablo.bakeryManager.application.modules.product.productUpdater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.DatabaseIntegrityExceptionHandler;
import com.pablo.bakeryManager.application.exception.ResourceNotFoundExceptionHandler;
import com.pablo.bakeryManager.application.modules.product.productFinder.ProductFinder;
import com.pablo.bakeryManager.dominio.models.Category;
import com.pablo.bakeryManager.dominio.models.Product;
import com.pablo.bakeryManager.infrastructure.repository.ProductRepository;

@Service
public class ProductUpdater {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductFinder productFinder;
	
	public Product update(Long idProduct, ProductUpdaterRequest request) throws DatabaseIntegrityExceptionHandler, ResourceNotFoundExceptionHandler {
		
		this.ensureProductNameIsUnique(request.getProductName().value(), idProduct);
	
		Product product = productFinder.find(idProduct);
		
		product.setCategory(Category.builder().idCategory(request.getProductIdCategory().value()).build());
		product.setName(request.getProductName().value());
		product.setVisible(request.getProductVisible().value());
		
		productRepository.save(product);
		productRepository.refresh(product);
		
		return product;
	}
	
	private void ensureProductNameIsUnique(String name, Long idProduct) throws DatabaseIntegrityExceptionHandler {
		
		Product product = productRepository.findByName(name);
		
		if (product != null) {
			
			if (product.getIdProduct() != idProduct) {
				throw new DatabaseIntegrityExceptionHandler("name", ErrorMessage.exists(name));
			}
		}
	}
}
