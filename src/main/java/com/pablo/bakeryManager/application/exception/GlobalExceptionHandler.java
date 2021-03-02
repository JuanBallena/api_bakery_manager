package com.pablo.bakeryManager.application.exception;

import java.util.ArrayList;
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

import com.pablo.bakeryManager.application.serviceResponse.ServiceResponse;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseBadRequest;
import com.pablo.bakeryManager.application.serviceResponse.ServiceResponseServerError;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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
		System.out.println("1 exception");
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
		System.out.println("2 exception");
		return exceptionResponseEntity(exception, HttpStatus.BAD_REQUEST, request, validationErrors);
	}

	private ResponseEntity<Object> exceptionResponseEntity(final Exception exception,
		final HttpStatus status, final WebRequest request, final List<String> errors) {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		
		Map<String, Object> details = new LinkedHashMap<>();

		details.put("timestamp", new Date());
		details.put("type", exception.getClass().getSimpleName());
		details.put("path", request.getDescription(false));
		details.put("message", errors);
		
		serviceResponse.setStatusCode(status.value());
		serviceResponse.setStatusMessage(status.toString());
		serviceResponse.setError(details);

		return new ResponseEntity<>(serviceResponse, status);
	}
	
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		
		ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
		HttpStatus status = responseStatus != null ? responseStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
		String localizedMessage = exception.getLocalizedMessage();
		String message = !localizedMessage.isEmpty() ? localizedMessage : status.getReasonPhrase();
			
		GlobalExceptionError errorException = GlobalExceptionError.builder()
												.timestamp(new Date())
												.type(exception.getClass().getSimpleName())
												.path(request.getDescription(false))
												.message(message)
												.build();
		
		ServiceResponse serviceResponse = new ServiceResponse();
		
		serviceResponse.setStatusCode(ServiceResponseServerError.STATUS_CODE);
		serviceResponse.setStatusMessage(ServiceResponseServerError.STATUS_MESSAGE);
		serviceResponse.setError(errorException);
		
		return new ResponseEntity<>(serviceResponse, status);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
		HttpMessageNotReadableException exception,
		HttpHeaders headers, 
		HttpStatus status, 
		WebRequest request
	) {
		
		GlobalExceptionError errorException = GlobalExceptionError.builder()
											.timestamp(new Date())
											.type(exception.getClass().getSimpleName())
											.path(request.getDescription(false))
											.message(exception.getLocalizedMessage())
											.build();
		
		ServiceResponse serviceResponse = new ServiceResponse();
		
		serviceResponse.setStatusCode(ServiceResponseBadRequest.STATUS_CODE);
		serviceResponse.setStatusMessage(ServiceResponseBadRequest.STATUS_MESSAGE);
		serviceResponse.setError(errorException);
		
		return new ResponseEntity<>(serviceResponse, status);
	}
}

