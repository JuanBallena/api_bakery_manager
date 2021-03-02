package com.pablo.bakeryManager.application.exception;

import com.pablo.bakeryManager.application.interfaces.ExceptionError;

public abstract class NotFoundExceptionHandler extends Exception {

	private static final long serialVersionUID = 1L;

	abstract public ExceptionError exceptionInfo();
}
