package com.pablo.bakeryManager.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pablo.bakeryManager.definition.ResponseCodeDefinition;
import com.pablo.bakeryManager.response.ServiceResponse;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> errorList = new ArrayList<String>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<ObjectError> objectErrors = exception.getBindingResult().getGlobalErrors();
		
		for (FieldError fieldError : fieldErrors) {
			errorList.add(fieldError.getDefaultMessage());
		}
		
		for (ObjectError error : objectErrors) {
			errorList.add(error.getDefaultMessage());
		}
		
		return exceptionResponseEntity(exception, HttpStatus.BAD_REQUEST, request, errorList);
	}
	
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstraintViolation(
		ConstraintViolationException exception, 
		WebRequest request
	) {
		final List<String> validationErrors = exception.getConstraintViolations()
				.stream()
				.map(violation -> violation.getMessage())
				.collect(Collectors.toList());
		
		return exceptionResponseEntity(exception, HttpStatus.BAD_REQUEST, request, validationErrors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return exceptionResponseEntity(exception, status, request, Collections.singletonList(exception.getLocalizedMessage()));
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		
		ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
		final HttpStatus status = responseStatus != null ? responseStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
		final String localizedMessage = exception.getLocalizedMessage();
		String message = (!localizedMessage.isEmpty() ? localizedMessage:status.getReasonPhrase());
		
		return exceptionResponseEntity(exception, status, request, Collections.singletonList(message));
	}

	private ResponseEntity<Object> exceptionResponseEntity(final Exception exception,
		final HttpStatus status, final WebRequest request, final List<String> errors) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		
		final Map<String, Object> details = new LinkedHashMap<>();
		final String path = request.getDescription(false);
		details.put("timestamp", new Date());
		details.put("type", exception.getClass().getSimpleName());
		details.put("path", path);
		details.put("message", errors);
		
		serviceResponse.setStatusCode(status.value());
		serviceResponse.setStatusMessage(getMessageForStatus(status));
		serviceResponse.setException(details);

		return new ResponseEntity<>(serviceResponse, status);
	}

	private String getMessageForStatus(HttpStatus status) {
		switch (status) {
			case UNAUTHORIZED:
				return ResponseCodeDefinition.RESPONSE_CODE_UNAUTHORIZED_S;
			case BAD_REQUEST:
				return ResponseCodeDefinition.RESPONSE_CODE_BAD_REQUEST_S;
			default:
				return status.getReasonPhrase();
		}
	}
}

