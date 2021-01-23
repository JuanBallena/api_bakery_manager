package com.pablo.bakeryManager.annotation;

import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pablo.bakeryManager.ApplicationContextProvider;
import com.pablo.bakeryManager.interf.UniqueDataValidator;

public class UniqueToUpdateImpl implements ConstraintValidator<UniqueToUpdate, Map<String, Object>> {

	private UniqueDataValidator uniqueDataValidator;
	private String property;
	
	@Override
    public void initialize(UniqueToUpdate annotation) {

		Class<? extends UniqueDataValidator> clazz = annotation.uniqueDataValidator();
		this.uniqueDataValidator = ApplicationContextProvider.getApplicationContext().getBean(clazz);
		this.property = annotation.property();
	}
	
    @Override
    public boolean isValid(Map<String, Object> map, ConstraintValidatorContext context) {
    	
    	return this.uniqueDataValidator.isValidToUpdate(this.property, map.get("value"), Long.valueOf(map.get("id").toString()));
    }
}
