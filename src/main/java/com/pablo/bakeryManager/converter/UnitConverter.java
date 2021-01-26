package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.response.UnitDTO;
import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.model.Unit;

@Component
public class UnitConverter implements Converter<Unit, UnitDTO> {

	@Override
	public UnitDTO toDTO(Unit u) {
		
		return UnitDTO.builder()
				.id(u.getIdUnit())
				.name(u.getName())
				.visible(u.getVisible())
				.build();
	}

	@Override
	public List<UnitDTO> toDTOList(List<Unit> units) {
		
		List<UnitDTO> unitDTOList = new ArrayList<UnitDTO>();
		units.forEach(unit -> unitDTOList.add(toDTO(unit)));
		return unitDTOList;
	}

}
