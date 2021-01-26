package com.pablo.bakeryManager.controller.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.bakeryManager.dto.request.product.RequestUpdateProductDTO;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.product.ProductUpdater;

@RestController
public class ProductsPutController {

	@Autowired
	private ProductUpdater productUpdater;
	
	@PutMapping("/products/{idProduct}")
	public ServiceResponse updateProduct(@PathVariable("idProduct") Long idProduct, @RequestBody RequestUpdateProductDTO requestDTO) {
		
		return productUpdater.putData(idProduct, requestDTO);
	}
}
