package com.pablo.bakeryManager.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.request.ProductRequest;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.product.ServiceFindAllProducts;
import com.pablo.bakeryManager.services.product.ServiceFindByIdProduct;

@RestController
public class ProductsGetController {

	@Autowired
	private ServiceFindAllProducts serviceFindAllProducts;
	
	@Autowired
	private ServiceFindByIdProduct serviceFindByIdProduct;
	
	@GetMapping("/products")
	public ServiceResponse getProducts(ProductRequest request) {

		return serviceFindAllProducts.getData(request);
	}
	
	@GetMapping("/products/{idProduct}")
	public ServiceResponse getProduct(@PathVariable("idProduct") Long idProduct) {
		
		return serviceFindByIdProduct.getData(idProduct);
	}
}
