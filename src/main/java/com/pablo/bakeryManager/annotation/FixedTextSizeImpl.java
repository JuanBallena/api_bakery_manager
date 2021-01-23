package com.pablo.bakeryManager.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FixedTextSizeImpl implements ConstraintValidator<FixedTextSize, String> {
	
	private int size;
	
	@Override
    public void initialize(FixedTextSize annotation) {

		this.size = annotation.size();
	}
	
    @Override
    public boolean isValid(String text, ConstraintValidatorContext context) {
    	
    	int textLength = text.length();
    	return textLength == this.size;
    }
 
}
