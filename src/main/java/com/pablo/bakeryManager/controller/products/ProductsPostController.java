package com.pablo.bakeryManager.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.product.RequestCreateProductDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.product.ProductCreator;

@RestController
public class ProductsPostController {

	@Autowired
	private ProductCreator productCreator;

	@PostMapping("/products")
	public ServiceResponse saveProduct(@RequestBody RequestCreateProductDTO requestDTO) {
		
		return productCreator.postData(requestDTO);
	}
}
