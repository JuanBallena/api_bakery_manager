package com.pablo.bakeryManager.infrastructure.controller.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.application.modules.product.productsFinder.ProductsFinderQuery;
import com.pablo.bakeryManager.dominio.interfaces.Response;
import com.pablo.bakeryManager.infrastructure.controller.ApiController;
import com.pablo.bakeryManager.infrastructure.requestParams.ProductRequestParams;

@RestController
public class ProductsGetCustomers extends ApiController {

	@GetMapping("/products")
	public Response getProducts(ProductRequestParams request) {
		
		return super.ask(new ProductsFinderQuery(request));
	}
}
