package com.pablo.bakeryManager.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = FixedTextSizeImpl.class)
@Documented
public @interface FixedTextSize {

	int size();
	
	String message() default "message fixed length";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
