package com.pablo.bakeryManager.application.exception;

import java.util.Date;

import com.pablo.bakeryManager.application.interfaces.ExceptionError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestBodyExceptionHandler extends BadRequestExceptionHandler {

	private static final long serialVersionUID = 1L;
	
	private String field;
	private String message;
	
	public ExceptionError exceptionInfo() {
		
		return RequestBodyError.builder()
				.timestamp(new Date())
				.type(RequestBodyExceptionHandler.class.getSimpleName())
				.field(this.field)
				.message(this.message)
				.build();
	}
}
