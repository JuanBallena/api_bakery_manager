package com.pablo.bakeryManager.controller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.category.RequestCreateCategoryDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.category.ServiceCreateCategory;

@RestController
public class CategoriesPostController {

	@Autowired
	private ServiceCreateCategory serviceCreateCategory;

	@PostMapping("/categories")
	public ServiceResponse saveCategory(@RequestBody RequestCreateCategoryDTO requestDTO) {
		
		return serviceCreateCategory.postData(requestDTO);
	}
}
