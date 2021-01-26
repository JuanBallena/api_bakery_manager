package com.pablo.bakeryManager.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.params.CategoryParams2;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.category.CategoryFinder;
import com.pablo.bakeryManager.services.category.CategoryFinderById;

@RestController
public class CategoriesGetController {
	
	@Autowired
	private CategoryFinder categoryFinder;
	
	@Autowired
	private CategoryFinderById categoryFinderById;
	
	@GetMapping("/categories")
	public ServiceResponse getCategories(CategoryParams2 params) {

		return categoryFinder.getData(params);
	}
	
	@GetMapping("/categories/{idCategory}")
	public ServiceResponse getCategory(@PathVariable("idCategory") Long idCategory) {
		
		return categoryFinderById.getData(idCategory);
	}
}
