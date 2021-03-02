package com.pablo.bakeryManager.application.modules.customer.valueObject;

import java.util.regex.Pattern;

import com.pablo.bakeryManager.application.definition.Regex;
import com.pablo.bakeryManager.application.error.ErrorMessage;
import com.pablo.bakeryManager.application.exception.RequestBodyExceptionHandler;

public class CustomerPhone {

	private static final String FIELD_PHONE = "phone";
	private String value;
	
	public CustomerPhone(String phone) throws RequestBodyExceptionHandler {
		
		this.ensurePhoneIsValid(phone);
		this.value = phone;
	}
	
	public String value() {
		
		return this.value;
	}
	
	private void ensurePhoneIsValid(String phone) throws RequestBodyExceptionHandler {
		
		this.ensurePhoneIsNotNull(phone);
		this.ensurePhoneHasOnlyNumbers(phone);
	}
	
	private void ensurePhoneIsNotNull(String phone) throws RequestBodyExceptionHandler {
		
		if (phone == null) {
			throw new RequestBodyExceptionHandler(FIELD_PHONE, ErrorMessage.notNull);
		}
	}
	
	private void ensurePhoneHasOnlyNumbers(String phone) throws RequestBodyExceptionHandler {
		
		if (!Pattern.matches(Regex.PATTERN_ONLY_NUMBERS, phone)) {
			throw new RequestBodyExceptionHandler(FIELD_PHONE, ErrorMessage.onlyNumbers);
		}
	}
}
