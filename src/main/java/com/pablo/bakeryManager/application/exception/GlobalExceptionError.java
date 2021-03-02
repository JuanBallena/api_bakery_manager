package com.pablo.bakeryManager.application.exception;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class GlobalExceptionError {

	private Date timestamp;
	private String type;
	private String path;
	private String message;
}