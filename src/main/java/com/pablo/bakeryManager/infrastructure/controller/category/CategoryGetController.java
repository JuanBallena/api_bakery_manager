package com.pablo.bakeryManager.infrastructure.controller.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.category.categoryFinder.CategoryFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;

@RestController
public class CategoryGetController extends ApiController {
	
	@GetMapping("/categories/{id}")
	public Response getCategory(@PathVariable("id") Long idCategory) {
		
		return super.ask(new CategoryFinderQuery(idCategory));
	}
}
