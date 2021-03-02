package com.pablo.bakeryManager.application.error;

public class ErrorMessage {

	public static final String notNull = "No debe ser nulo";
	public static final String notEmpty = "No deber estar vacío";
	public static final String positive = "Debe ser positivo";
	public static final String onlyNumbers = "Sólo números";
	
	public static final String size(int min, int max) {
		
		return "De " + min + " a " + max + " caracteres";
	}
	
	public static final String exists(String value) {
		
		return "El valor " + value + " ya ha sido registrado";
	}
}
