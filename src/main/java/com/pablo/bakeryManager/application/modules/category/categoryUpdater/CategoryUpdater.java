package com.pablo.bakeryManager.application.modules.category.categoryUpdater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.DatabaseIntegrityExceptionHandler;
import com.pablo.bakeryManager.application.exception.ResourceNotFoundExceptionHandler;
import com.pablo.bakeryManager.application.modules.category.categoryFinder.CategoryFinder;
import com.pablo.bakeryManager.dominio.models.Category;
import com.pablo.bakeryManager.infrastructure.repository.CategoryRepository;

@Service
public class CategoryUpdater {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryFinder categoryFinder;
	
	public Category update(Long idCategory, CategoryUpdaterRequest request) throws DatabaseIntegrityExceptionHandler, ResourceNotFoundExceptionHandler {
		
		this.ensureCategoryNameIsUnique(request.getCategoryName().value(), idCategory);
		
		Category category = categoryFinder.find(idCategory);
		
		category.setName(request.getCategoryName().value());
		category.setVisible(request.getCategoryVisible().value());
		
		categoryRepository.save(category);
		categoryRepository.refresh(category);
		
		return category;
	}
	
	private void ensureCategoryNameIsUnique(String name, Long idCategory) throws DatabaseIntegrityExceptionHandler {
		
		Category category = categoryRepository.findByName(name);
		
		if (category != null) {
			
			if (category.getIdCategory() != idCategory) {
				throw new DatabaseIntegrityExceptionHandler("name", ErrorMessage.exists(name));
			}
		}
	}
}
