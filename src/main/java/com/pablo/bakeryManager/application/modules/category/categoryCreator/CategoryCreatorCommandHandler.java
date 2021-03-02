package com.pablo.bakeryManager.application.modules.category.categoryCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.exception.BadRequestExceptionHandler;
import com.pablo.bakeryManager.application.modules.category.CategoryResponse;
import com.pablo.bakeryManager.application.modules.category.CategoryResponseConverter;
import com.pablo.bakeryManager.application.serviceResponse.ResourceType;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseBadRequest;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseCreated;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;
import com.pablo.bakeryManager.dominio.interfaces.CommandHandler;
import com.pablo.bakeryManager.dominio.models.Category;

@Component
public class CategoryCreatorCommandHandler implements CommandHandler<CategoryCreatorCommand, ServiceResponse> {
	
	@Autowired
	private CategoryCreator categoryCreator;
	
	@Autowired
	private CategoryResponseConverter categoryResponseConverter;
	
	@Override
	public ServiceResponse handle(CategoryCreatorCommand command) {
		
		try {
			
			CategoryCreatorRequest request = CategoryCreatorRequest.build(command.request);
			
			Category category = categoryCreator.create(request);
			
			CategoryResponse categoryResponse = categoryResponseConverter.convert(category);
			
			return new ServiceResponseCreated(ResourceType.CATEGORY, categoryResponse);
			
		} catch (BadRequestExceptionHandler e) {
			return new ServiceResponseBadRequest(ResourceType.CATEGORY, e.exceptionInfo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ServiceResponseServerError();
	}
}
