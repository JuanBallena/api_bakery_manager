package com.pablo.bakeryManager.application.modules.product.productsFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.infrastructure.requestParams.ProductRequestParams;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductsFinderQuery implements Query {

	public ProductRequestParams params;
}
