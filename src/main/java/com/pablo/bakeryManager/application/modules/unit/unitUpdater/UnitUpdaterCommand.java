package com.pablo.bakeryManager.application.modules.unit.unitUpdater;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnitUpdaterCommand implements Command {
	
	private Long idUnit;
	private RequestUpdateUnit requestUpdateUnit;
}
