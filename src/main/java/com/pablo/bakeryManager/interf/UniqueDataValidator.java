package com.pablo.bakeryManager.interf;

public interface UniqueDataValidator {

	public boolean isValidToCreate(String property, Object value);
	public boolean isValidToUpdate(String property, Object value, Long id);
}
