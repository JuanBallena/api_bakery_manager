package com.pablo.bakeryManager.application.modules.product.productFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductFinderQuery implements Query {

	public Long idProduct;
}
