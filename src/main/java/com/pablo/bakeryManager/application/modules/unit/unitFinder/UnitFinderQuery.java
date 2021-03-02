package com.pablo.bakeryManager.application.modules.unit.unitFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnitFinderQuery implements Query {

	private Long idUnit;
}
