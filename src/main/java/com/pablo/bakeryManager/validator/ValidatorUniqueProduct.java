package com.pablo.bakeryManager.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.UniqueDataValidator;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;

@Component
public class ValidatorUniqueProduct implements UniqueDataValidator {

	private Validator validator = new Validator();
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean isValidToCreate(String propertyClass, Object value) {
		
		Product product = findProduct(propertyClass, value);
		return validator.isNull(product);
	}

	@Override
	public boolean isValidToUpdate(String propertyClass, Object value, Long id) {
		
		Product product = findProduct(propertyClass, value);
		
		if (validator.notNull(product)) {
			
			return product.getIdProduct().equals(id);
		}
		return true;	
	}
	
	private Product findProduct(String propertyClass, Object value) {
		
		switch (propertyClass) {
			case Product.NAME:
				return productRepository.findByName(value.toString());
			default:
				return null;
		}
	}
}
