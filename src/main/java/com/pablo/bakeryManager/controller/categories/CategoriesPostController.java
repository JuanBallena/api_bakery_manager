package com.pablo.bakeryManager.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.category.RequestCreateCategoryDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.category.CategoryCreator;

@RestController
public class CategoriesPostController {

	@Autowired
	private CategoryCreator categoryCreator;

	@PostMapping("/categories")
	public ServiceResponse saveCategory(@RequestBody RequestCreateCategoryDTO requestDTO) {
		
		return categoryCreator.postData(requestDTO);
	}
}
