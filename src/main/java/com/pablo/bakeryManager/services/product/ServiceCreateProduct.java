package com.pablo.bakeryManager.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.ProductDTO;
import com.pablo.bakeryManager.dto.product.RequestCreateProductDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceCreateProduct {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceSave<Product, ProductDTO> serviceSave;
	
	public ServiceResponse postData(RequestCreateProductDTO requestDTO) {
		
		List<Object> errorList = validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			Product product = new Product();
			product.setCategory(Category.builder()
					.idCategory(requestDTO.getIdCategory())
					.build());
			product.setName(requestDTO.getName());
			
			ProductDTO productDTO = serviceSave.postData(product, productRepository, productConverter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.PRODUCT, productDTO);
		}
		
		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.PRODUCT, errorList);	
	}
}
