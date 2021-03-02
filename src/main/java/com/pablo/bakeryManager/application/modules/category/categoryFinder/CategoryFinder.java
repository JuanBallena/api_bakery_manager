package com.pablo.bakeryManager.application.modules.category.categoryFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.exception.ResourceNotFoundExceptionHandler;
import com.pablo.bakeryManager.dominio.models.Category;
import com.pablo.bakeryManager.infrastructure.repository.CategoryRepository;

@Service
public class CategoryFinder {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category find(Long idCategory) throws ResourceNotFoundExceptionHandler {
				
		Category category = categoryRepository.findById(idCategory).orElse(null);
		
		this.ensureCategoryExisting(category);
		
		return category;
	}
	
	private void ensureCategoryExisting(Category category) throws ResourceNotFoundExceptionHandler {
		
		if (category == null) {
			throw new ResourceNotFoundExceptionHandler("Categoria no existe");
		}
	}
}
