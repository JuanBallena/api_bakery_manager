package com.pablo.bakeryManager.application.modules.product.productCreator;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateProduct;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductCreatorCommand implements Command {

	public RequestCreateProduct request;
}
