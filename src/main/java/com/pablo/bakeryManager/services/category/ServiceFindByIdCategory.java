package com.pablo.bakeryManager.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CategoryConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.CategoryDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.repository.CategoryRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceFindById;

@Service
public class ServiceFindByIdCategory {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceFindById<Category, CategoryDTO> serviceFindById;
	
	public ServiceResponse getData(Long idCategory) {
		
		CategoryDTO categoryDTO = serviceFindById.getData(idCategory, categoryRepository, categoryConverter);
		
		if (categoryDTO == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.CATEGORY, categoryDTO);
		}
		
		return serviceResponseCreator.createResponseOk(ResponseTypeDefinition.CATEGORY, categoryDTO);
	}
}
