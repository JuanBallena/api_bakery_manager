package com.pablo.bakeryManager.application.modules.unit.valueObject;

public class UnitId {

	private Long value;
	
	public UnitId(Long idUnit) {
		
		this.validate(idUnit);
		this.value = idUnit;
	}
	
	public Long value() {
		
		return value;
	}
	
	private void validate(Long idUnit) {
		
	}
}
