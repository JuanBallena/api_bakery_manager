package com.pablo.bakeryManager.application.modules.parameter.parametersFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.infrastructure.requestParams.ParameterRequestParams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ParametersFinderQuery implements Query {

	private ParameterRequestParams request;
}
