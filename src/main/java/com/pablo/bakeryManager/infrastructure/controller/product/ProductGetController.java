package com.pablo.bakeryManager.infrastructure.controller.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.product.productFinder.ProductFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;

@RestController
public class ProductGetController extends ApiController {

	@GetMapping("/products/{id}")
	public Response getProduct(@PathVariable("id") Long idProduct) {
		
		return super.ask(new ProductFinderQuery(idProduct));
	}
}
