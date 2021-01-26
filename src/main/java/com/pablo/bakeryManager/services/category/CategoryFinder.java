package com.pablo.bakeryManager.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CategoryConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.CategoryDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.params.CategoryParams2;
import com.pablo.bakeryManager.repository.CategoryRepository;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ResponseToFinder;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.Finder;

@Service
public class CategoryFinder {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private Finder<Category, CategoryDTO> finder;
	
	@Autowired
	private ResponseToFinder responseToFinder;
	
	public ServiceResponse getData(CategoryParams2 params) {
		
		PageResponse pageResponse = finder.getData(params, categoryRepository, categoryConverter);
		
		return responseToFinder.dispatch(ResponseTypeDefinition.CATEGORIES, pageResponse);
	}
}
