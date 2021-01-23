package com.pablo.bakeryManager.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.request.CategoryRequest;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.category.ServiceFindAllCategories;
import com.pablo.bakeryManager.services.category.ServiceFindByIdCategory;

@RestController
public class CategoriesGetController {

	@Autowired
	private ServiceFindAllCategories serviceFindAllCategories;
	
	@Autowired
	private ServiceFindByIdCategory serviceFindByIdCategory;
	
	@GetMapping("/categories")
	public ServiceResponse getCategories(CategoryRequest request) {

		return serviceFindAllCategories.getData(request);
	}
	
	@GetMapping("/categories/{idCategory}")
	public ServiceResponse getCategory(@PathVariable("idCategory") Long idCategory) {
		
		return serviceFindByIdCategory.getData(idCategory);
	}
}
