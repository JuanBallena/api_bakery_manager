package com.pablo.bakeryManager.application.modules.category.categoryFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.exception.BadRequestExceptionHandler;
import com.pablo.bakeryManager.application.exception.NotFoundExceptionHandler;
import com.pablo.bakeryManager.application.modules.Id;
import com.pablo.bakeryManager.application.modules.category.CategoryResponse;
import com.pablo.bakeryManager.application.modules.category.CategoryResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseBadRequest;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNotFound;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseOk;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.QueryHandler;
import com.pablo.bakeryManager.dominio.models.Category;

@Component
public class CategoryFinderQueryHandler implements QueryHandler<CategoryFinderQuery, ServiceResponse> {
	
	@Autowired
	private CategoryFinder categoryFinder;
	
	@Autowired
	private CategoryResponseConverter categoryResponseConverter;

	@Override
	public ServiceResponse handle(CategoryFinderQuery query) {
		
		try {
						
			Id id = new Id(query.idCategory);
			
			Category category = categoryFinder.find(id.value());
			
			CategoryResponse categoryResponse = categoryResponseConverter.convert(category);
								
			return new ServiceResponseOk(ResourceType.CATEGORY, categoryResponse);
		
		} catch(BadRequestExceptionHandler e) {
			return new ServiceResponseBadRequest(ResourceType.CATEGORY, e.exceptionInfo());
			
		} catch(NotFoundExceptionHandler e) {
			return new ServiceResponseNotFound(ResourceType.CATEGORY, e.exceptionInfo());
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
