package com.pablo.bakeryManager.infrastructure.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.product.productCreator.ProductCreatorCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.bus.SyncCommandBus;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateProduct;

@RestController
public class ProductPostController {

	@Autowired
	private SyncCommandBus bus;
	
	@PostMapping("/products")
	public Response postProduct(@RequestBody RequestCreateProduct request) {
		
		return bus.dispatch(new ProductCreatorCommand(request));
	}
}
