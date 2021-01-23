package com.pablo.bakeryManager.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pablo.bakeryManager.ApplicationContextProvider;
import com.pablo.bakeryManager.interf.UniqueDataValidator;

public class UniqueToCreateImpl implements ConstraintValidator<UniqueToCreate, Object> {
	
	private UniqueDataValidator uniqueDataValidator;
	private String property;
	
	@Override
    public void initialize(UniqueToCreate annotation) {
		
		Class<? extends UniqueDataValidator> clazz = annotation.uniqueDataValidator();
		this.uniqueDataValidator = ApplicationContextProvider.getApplicationContext().getBean(clazz);
		this.property = annotation.property();
	}
	
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
    	
    	return this.uniqueDataValidator.isValidToCreate(this.property, value);
    }
}
