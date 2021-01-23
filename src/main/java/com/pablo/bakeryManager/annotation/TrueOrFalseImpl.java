package com.pablo.bakeryManager.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TrueOrFalseImpl implements ConstraintValidator<TrueOrFalse, Boolean> {

    @Override
    public boolean isValid(Boolean bool, ConstraintValidatorContext context) {
    	
    	return bool.equals(true) || bool.equals(false); 
    }
}
