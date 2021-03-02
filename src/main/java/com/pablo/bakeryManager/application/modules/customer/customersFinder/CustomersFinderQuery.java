package com.pablo.bakeryManager.application.modules.customer.customersFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.infrastructure.requestParams.CustomerRequestParams;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomersFinderQuery implements Query {

	public CustomerRequestParams params;
}
