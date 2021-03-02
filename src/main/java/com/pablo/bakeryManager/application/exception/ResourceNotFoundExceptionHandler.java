package com.pablo.bakeryManager.application.exception;

import java.util.Date;

import com.pablo.bakeryManager.application.interfaces.ExceptionError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceNotFoundExceptionHandler extends NotFoundExceptionHandler {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ExceptionError exceptionInfo() {
		
		return ResourceNotFoundError.builder()
				.timestamp(new Date())
				.type(ResourceNotFoundExceptionHandler.class.getSimpleName())
				.message(this.message)
				.build();
	}
}
