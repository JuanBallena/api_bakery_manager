package com.pablo.bakeryManager.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.product.RequestCreateProductDTO;
import com.pablo.bakeryManager.dto.response.ProductDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ProductCreator {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Product, ProductDTO> creator;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse postData(RequestCreateProductDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			ProductDTO productDTO = this.saveData(requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.PRODUCT, productDTO);
		}
		
		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.PRODUCT, errorList);	
	}
	
	private ProductDTO saveData(RequestCreateProductDTO requestDTO) {
		
		Product product = new Product();
		product.setCategory(Category.builder().idCategory(requestDTO.getIdCategory()).build());
		product.setName(requestDTO.getName());
		
		return creator.saveData(product, productRepository, productConverter);
	}
}
