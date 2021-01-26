package com.pablo.bakeryManager.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.CategoryConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.response.CategoryDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.repository.CategoryRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ResponseToFinderById;
import com.pablo.bakeryManager.services.FinderById;

@Service
public class CategoryFinderById {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private FinderById<Category, CategoryDTO> finderById;
	
	@Autowired
	private ResponseToFinderById responseToFinderById;
	
	public ServiceResponse getData(Long idCategory) {
		
		CategoryDTO categoryDTO = finderById.getData(idCategory, categoryRepository, categoryConverter);
		
		return responseToFinderById.dispatch(ResponseTypeDefinition.CATEGORY, categoryDTO);
	}
}
