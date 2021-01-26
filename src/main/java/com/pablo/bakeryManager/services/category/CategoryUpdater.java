
package com.pablo.bakeryManager.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CategoryConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.category.RequestUpdateCategoryDTO;
import com.pablo.bakeryManager.dto.response.CategoryDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.repository.CategoryRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.response.ServiceResponseCreatorNotFound;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.services.DatabaseChecker;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class CategoryUpdater {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private DatabaseChecker<Category> databaseChecker;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Category, CategoryDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorNotFound serviceResponseCreatorNotFound;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse putData(Long idCategory, RequestUpdateCategoryDTO requestDTO) {
		
		Category category = databaseChecker.check(idCategory, categoryRepository);
		
		if (category == null) {
			
			return serviceResponseCreatorNotFound.build(ResponseTypeDefinition.CATEGORY);
		}
		
		List<Object> errorListCategory =  validatorRequestDTO.validate(requestDTO);
		
		if (errorListCategory.isEmpty()) {
			
			CategoryDTO categoryDTO = this.saveData(category, requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.CATEGORY, categoryDTO);
		}

		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.CATEGORY, errorListCategory);
	}
	
	private CategoryDTO saveData(Category category, RequestUpdateCategoryDTO requestDTO) {
		
		category.setName(requestDTO.getName());
		category.setVisible(requestDTO.getVisible());
		
		return creator.saveData(category, categoryRepository, categoryConverter);
	}
}
