package com.pablo.bakeryManager.infrastructure.controller.category;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.category.categoryUpdater.CategoryUpdaterCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateCategory;

@RestController
public class CategoryPutController extends ApiController {
	
	@PutMapping("/categories/{id}")
	public Response putCategory(@PathVariable("id") Long idCategory, @RequestBody RequestUpdateCategory request) {
		
		return super.dispatch(new CategoryUpdaterCommand(idCategory, request));
	}
}
