package com.pablo.bakeryManager.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.UniqueDataValidator;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.repository.CategoryRepository;

@Component
public class ValidatorUniqueCategory implements UniqueDataValidator {

	private Validator validator = new Validator();
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public boolean isValidToCreate(String propertyClass, Object value) {
		
		Category category = findCategory(propertyClass, value);
		return validator.isNull(category);
	}

	@Override
	public boolean isValidToUpdate(String propertyClass, Object value, Long id) {
		
		Category category = findCategory(propertyClass, value);
		
		if (validator.notNull(category)) {
			
			return category.getIdCategory().equals(id);
		}
		return true;	
	}
	
	private Category findCategory(String propertyClass, Object value) {
		
		switch (propertyClass) {
			case Category.NAME:
				return categoryRepository.findByName(value.toString());
			default:
				return null;
		}
	}
}
