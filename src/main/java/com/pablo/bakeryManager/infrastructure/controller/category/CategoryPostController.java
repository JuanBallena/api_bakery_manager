package com.pablo.bakeryManager.infrastructure.controller.category;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.category.categoryCreator.CategoryCreatorCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateCategory;

@RestController
public class CategoryPostController extends ApiController {

	@PostMapping("/categories")
	public Response postCategory(@RequestBody RequestCreateCategory request) {
		
		return super.dispatch(new CategoryCreatorCommand(request));
	}
}
