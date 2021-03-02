package com.pablo.bakeryManager.application.modules.unit;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.application.converter.ResponseConverter;
import com.pablo.bakeryManager.dominio.models.Unit;

@Component
public class UnitResponseConverter extends ResponseConverter<Unit, UnitResponse> {

	@Override
	public UnitResponse convert(Unit unit) {
		
		return UnitResponse.builder()
				.id(unit.getIdUnit())
				.name(unit.getName())
				.visible(unit.getVisible())
				.build();
	}
}
