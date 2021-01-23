package com.pablo.bakeryManager.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.pablo.bakeryManager.interf.UniqueDataValidator;

@Target({METHOD, })
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueToUpdateImpl.class)
@Documented
public @interface UniqueToUpdate {

	String message() default "message unique to update";
	
	String property();

	Class<? extends UniqueDataValidator> uniqueDataValidator();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
