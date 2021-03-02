package com.pablo.bakeryManager.application.modules.category.categoriesFinder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.criteria.paging.Pagination;
import com.pablo.bakeryManager.application.modules.category.CategoryResponse;
import com.pablo.bakeryManager.application.modules.category.CategoryResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNoContent;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseOk;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;
import com.pablo.bakeryManager.dominio.models.Category;

@Component
public class CategoriesFinderQueryHandler implements QueryHandler<CategoriesFinderQuery, ServiceResponse> {

	@Autowired
	private CategoriesFinder categoriesFinder;
	
	@Autowired
	private CategoryResponseConverter categoryResponseConverter;
	
	@Override
	public ServiceResponse handle(CategoriesFinderQuery query) {
				
		try {
			
			CategoriesFinderCriteria criteria = new CategoriesFinderCriteria(CategoriesFinderRequest.create(query.params));
						
			Pagination<Category> pagination = categoriesFinder.find(criteria);
			
			if (pagination.hasData()) {
				
				List<CategoryResponse> categoriesResponse = categoryResponseConverter.convertList(pagination.getData());
				
				return new ServiceResponseOk(ResourceType.CATEGORIES, categoriesResponse, pagination.getTotalPages());
			}
						
			return new ServiceResponseNoContent(ResourceType.CATEGORIES, pagination.getData());		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
