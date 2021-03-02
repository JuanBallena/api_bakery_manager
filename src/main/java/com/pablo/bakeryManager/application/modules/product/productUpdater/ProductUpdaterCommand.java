package com.pablo.bakeryManager.application.modules.product.productUpdater;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateProduct;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductUpdaterCommand implements Command {

	public Long idProduct;
	public RequestUpdateProduct request;
}
