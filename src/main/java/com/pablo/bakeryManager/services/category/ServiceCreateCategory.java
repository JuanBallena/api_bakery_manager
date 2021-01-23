package com.pablo.bakeryManager.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CategoryConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.CategoryDTO;
import com.pablo.bakeryManager.dto.category.RequestCreateCategoryDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.repository.CategoryRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceCreateCategory {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceSave<Category, CategoryDTO> serviceSave;
	
	public ServiceResponse postData(RequestCreateCategoryDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			Category category = new Category();
			category.setName(requestDTO.getName());
			
			CategoryDTO categoryDTO = serviceSave.postData(category, categoryRepository, categoryConverter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.CATEGORY, categoryDTO);
		}
		
		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.CATEGORY, errorList);	
	}
}
