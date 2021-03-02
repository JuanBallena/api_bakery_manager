package com.pablo.bakeryManager.application.modules.category.categoriesFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.criteria.paging.Pagination;
import com.pablo.bakeryManager.dominio.models.Category;
import com.pablo.bakeryManager.infrastructure.generic.FindAllGeneric;
import com.pablo.bakeryManager.infrastructure.repository.CategoryRepository;

@Service
public class CategoriesFinder {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private FindAllGeneric<Category> findAllGeneric;
	
	public Pagination<Category> find(CategoriesFinderCriteria criteria) {
		
		return findAllGeneric.find(categoryRepository, criteria);
	}
}
