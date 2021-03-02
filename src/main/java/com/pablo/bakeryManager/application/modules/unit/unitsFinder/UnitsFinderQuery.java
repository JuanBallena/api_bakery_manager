package com.pablo.bakeryManager.application.modules.unit.unitsFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.infrastructure.requestParams.UnitRequestParams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnitsFinderQuery implements Query {

	private UnitRequestParams request;
}
