package com.pablo.bakeryManager.infrastructure.controller.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.product.productUpdater.ProductUpdaterCommand;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateProduct;

@RestController
public class ProductPutController extends ApiController {
	
	@PutMapping("/products/{id}")
	public Response putProduct(@PathVariable("id") Long idProduct, @RequestBody RequestUpdateProduct request) {
		
		return super.dispatch(new ProductUpdaterCommand(idProduct, request));
	}
}
