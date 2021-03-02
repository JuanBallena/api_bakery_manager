package com.pablo.bakeryManager.application.exception;

import java.util.Date;

import com.pablo.bakeryManager.application.interfaces.ExceptionError;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PathVariableError implements ExceptionError {

	private Date timestamp;
	private String type;
	private String message;
}
