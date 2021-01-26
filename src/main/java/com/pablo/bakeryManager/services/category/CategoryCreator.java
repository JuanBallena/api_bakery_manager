package com.pablo.bakeryManager.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.converter.CategoryConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.category.RequestCreateCategoryDTO;
import com.pablo.bakeryManager.dto.response.CategoryDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.repository.CategoryRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Component
public class CategoryCreator {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Category, CategoryDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse postData(RequestCreateCategoryDTO requestDTO) {
		
		List<Object> errorListCategory = validatorRequestDTO.validate(requestDTO);
		
		if (errorListCategory.isEmpty()) {
			
			CategoryDTO categoryDTO = this.saveData(requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.CATEGORY, categoryDTO);
		}
		
		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.CATEGORY, errorListCategory);
	}
	
	private CategoryDTO saveData(RequestCreateCategoryDTO requestDTO) {
		
		Category category = new Category();
		category.setName(requestDTO.getName());
		
		return creator.saveData(category, categoryRepository, categoryConverter);
	}
}
