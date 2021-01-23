package com.pablo.bakeryManager.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CategoryConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.CategoryDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.repository.CategoryRepository;
import com.pablo.bakeryManager.request.CategoryRequest;
import com.pablo.bakeryManager.response.PageResponse;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindAll;

@Service
public class ServiceFindAllCategories {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindAll<Category, CategoryDTO> serviceFindAll;
	
	public ServiceResponse getData(CategoryRequest request) {
		
		PageResponse pageResponse = serviceFindAll.getData(request, categoryRepository, categoryConverter);
		
		if (pageResponse.hasData()) {
			
			return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.CATEGORIES, pageResponse);
		}
		
		return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.CATEGORIES, pageResponse);
	}
}
