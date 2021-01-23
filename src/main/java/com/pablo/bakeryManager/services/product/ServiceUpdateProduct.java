package com.pablo.bakeryManager.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.creator.ServiceResponseCreator;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.ProductDTO;
import com.pablo.bakeryManager.dto.product.RequestUpdateProductDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.services.ServiceVerifyDB;
import com.pablo.bakeryManager.services.ServiceSave;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ServiceUpdateProduct {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ServiceVerifyDB<Product> serviceVerifyDB;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private ServiceResponseCreator serviceResponseCreator;
	
	@Autowired
	private ServiceSave<Product, ProductDTO> serviceSave;
	
	public ServiceResponse putData(Long idProduct, RequestUpdateProductDTO requestDTO) {
		
		Product product = serviceVerifyDB.check(idProduct, productRepository);
		
		if (product == null) {
			
			return serviceResponseCreator.createResponseNoContent(ResponseTypeDefinition.PRODUCT);
		}
		
		List<Object> errorList =  validatorRequestDTO.validate(requestDTO);
		
		if (errorList.isEmpty()) {
			
			product.setName(requestDTO.getName());
			product.setCategory(Category.builder()
					.idCategory(requestDTO.getIdCategory())
					.build());
			product.setVisible(requestDTO.getVisible());
			
			ProductDTO productDTO = serviceSave.postData(product, productRepository, productConverter);
			
			return serviceResponseCreator.createResponseCreated(ResponseTypeDefinition.PRODUCT, productDTO);
		}

		return serviceResponseCreator.createResponseBadRequest(ResponseTypeDefinition.PRODUCT, errorList);
		
	}
}
