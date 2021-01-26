package com.pablo.bakeryManager.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.category.RequestUpdateCategoryDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.category.CategoryUpdater;

@RestController
public class CategoriesPutController {

	@Autowired
	private CategoryUpdater categoryUpdater;
	
	@PutMapping("/categories/{idCategory}")
	public ServiceResponse updateCategory(@PathVariable("idCategory") Long idCategory, @RequestBody RequestUpdateCategoryDTO requestDTO) {
		
		return categoryUpdater.putData(idCategory, requestDTO);
		
	}
}
