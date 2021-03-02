package com.pablo.bakeryManager.application.modules.category.categoryUpdater;

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
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseCreated;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseNotFound;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.CommandHandler;
import com.pablo.bakeryManager.dominio.models.Category;

@Component
public class CategoryUpdaterCommandHandler implements CommandHandler<CategoryUpdaterCommand, ServiceResponse>{
		
	@Autowired
	private CategoryUpdater categoryUpdater;
	
	@Autowired
	private CategoryResponseConverter categoryResponseConverter;

	@Override
	public ServiceResponse handle(CategoryUpdaterCommand command) {
		
		try {
			
			Id id = new Id(command.idCategory);
			
			CategoryUpdaterRequest request = CategoryUpdaterRequest.build(command.request);
			
			Category category = categoryUpdater.update(id.value(), request);
		
			CategoryResponse categoryResponse = categoryResponseConverter.convert(category);
			
			return new ServiceResponseCreated(ResourceType.CATEGORY, categoryResponse);
		
		} catch (BadRequestExceptionHandler e) {
			return new ServiceResponseBadRequest(ResourceType.CATEGORY, e.exceptionInfo());
			
		} catch (NotFoundExceptionHandler e) {
			return new ServiceResponseNotFound(ResourceType.CATEGORY, e.exceptionInfo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
