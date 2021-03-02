package com.pablo.bakeryManager.infrastructure.controller.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.category.categoriesFinder.CategoriesFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestParams.CategoryRequestParams;

@RestController
public class CategoriesGetController extends ApiController {
	
	@GetMapping("/categories")
	public Response getCategories(CategoryRequestParams params) {

		return super.ask(new CategoriesFinderQuery(params));
	}
}
