package com.pablo.bakeryManager.application.modules.customer.customerFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerFinderQuery implements Query {

	public Long idCustomer;
}
