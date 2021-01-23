package com.pablo.bakeryManager.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.creator.ErrorMessageCreator;
import com.pablo.bakeryManager.interf.RequestDTO;

@Component
public class ValidatorRequestDTO {
	
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();

	public List<Object> validate(RequestDTO requestDTO) {
		
		List<Object> errorsMessage = new ArrayList<Object>();
		
		Set<ConstraintViolation<RequestDTO>> violations = validator.validate(requestDTO);
		
		if (violations.isEmpty()) {
			return errorsMessage;
		}
		
		return ErrorMessageCreator.builder(violations);
	}
}
