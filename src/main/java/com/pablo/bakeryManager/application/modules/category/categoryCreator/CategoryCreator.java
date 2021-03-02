package com.pablo.bakeryManager.application.modules.category.categoryCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.DatabaseIntegrityExceptionHandler;
import com.pablo.bakeryManager.dominio.models.Category;
import com.pablo.bakeryManager.infrastructure.repository.CategoryRepository;

@Service
public class CategoryCreator {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category create(CategoryCreatorRequest request) throws DatabaseIntegrityExceptionHandler {
		
		this.ensureCategoryNameIsUnique(request.getCategoryName().value());
		
		Category category = Category.create(request.getCategoryName().value());
		
		categoryRepository.save(category);
		categoryRepository.refresh(category);
		
		return category;
	}
	
	private void ensureCategoryNameIsUnique(String name) throws DatabaseIntegrityExceptionHandler {
		
		Category category = categoryRepository.findByName(name);
		
		if (category != null) {
			throw new DatabaseIntegrityExceptionHandler("name", ErrorMessage.exists(name));
		}
	}
}
