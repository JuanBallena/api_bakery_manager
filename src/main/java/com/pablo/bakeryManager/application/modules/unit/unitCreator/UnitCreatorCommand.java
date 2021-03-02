package com.pablo.bakeryManager.application.modules.unit.unitCreator;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnitCreatorCommand implements Command {

	private RequestCreateUnit requestCreateUnit;
}
