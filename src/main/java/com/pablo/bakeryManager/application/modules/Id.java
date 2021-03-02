package com.pablo.bakeryManager.application.modules;

import com.pablo.bakeryManager.application.exception.PathVariableExceptionHandler;

public class Id {

	private Long id;
	
	public Id(Long id) throws PathVariableExceptionHandler {
		
		this.ensureIdIsValid(id);
		this.id = id;
	}
	
	public Long value() {
		
		return this.id;
	}
	
	public void ensureIdIsValid(Long id) throws PathVariableExceptionHandler {
		
		if (id < 1) {
			throw new PathVariableExceptionHandler("Identificador invalido");
		}
	}
}
