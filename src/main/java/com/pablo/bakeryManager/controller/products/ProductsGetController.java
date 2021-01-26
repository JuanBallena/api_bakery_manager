package com.pablo.bakeryManager.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.params.ProductParams;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.product.ProductFinder;
import com.pablo.bakeryManager.services.product.ProductFinderById;

@RestController
public class ProductsGetController {

	@Autowired
	private ProductFinder productFinder;
	
	@Autowired
	private ProductFinderById productFinderById;
	
	@GetMapping("/products")
	public ServiceResponse getProducts(ProductParams params) {

		return productFinder.getData(params);
	}
	
	@GetMapping("/products/{idProduct}")
	public ServiceResponse getProduct(@PathVariable("idProduct") Long idProduct) {
		
		return productFinderById.getData(idProduct);
	}
}
