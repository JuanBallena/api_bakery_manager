package com.pablo.bakeryManager.application.modules.unit.valueObject;

public class UnitName {

	private String value;
	
	public UnitName(String name) {
		
		this.validate(name);
		this.value = name;
	}
	
	public String value() {
		
		return value;
	}
	
	private void validate(String name) {
		
	}
}
