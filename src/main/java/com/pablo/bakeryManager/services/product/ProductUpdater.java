package com.pablo.bakeryManager.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.converter.ProductConverter;
import com.pablo.bakeryManager.definition.ResponseTypeDefinition;
import com.pablo.bakeryManager.dto.request.product.RequestUpdateProductDTO;
import com.pablo.bakeryManager.dto.response.ProductDTO;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.repository.ProductRepository;
import com.pablo.bakeryManager.response.ServiceResponse;
import com.pablo.bakeryManager.response.ServiceResponseCreatorBadRequest;
import com.pablo.bakeryManager.response.ServiceResponseCreatorCreated;
import com.pablo.bakeryManager.response.ServiceResponseCreatorNotFound;
import com.pablo.bakeryManager.services.Creator;
import com.pablo.bakeryManager.services.DatabaseChecker;
import com.pablo.bakeryManager.validator.ValidatorRequestDTO;

@Service
public class ProductUpdater {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private DatabaseChecker<Product> databaseChecker;
	
	@Autowired
	private ValidatorRequestDTO validatorRequestDTO;
	
	@Autowired
	private Creator<Product, ProductDTO> serviceSave;
	
	@Autowired
	private ServiceResponseCreatorNotFound serviceResponseCreatorNotFound;
	
	@Autowired
	private ServiceResponseCreatorCreated serviceResponseCreatorCreated;
	
	@Autowired
	private ServiceResponseCreatorBadRequest serviceResponseCreatorBadRequest;
	
	public ServiceResponse putData(Long idProduct, RequestUpdateProductDTO requestDTO) {
		
		Product product = databaseChecker.check(idProduct, productRepository);
		
		if (product == null) {
			
			return serviceResponseCreatorNotFound.build(ResponseTypeDefinition.PRODUCT);
		}
		
		List<Object> errorListProduct =  validatorRequestDTO.validate(requestDTO);
		
		if (errorListProduct.isEmpty()) {
			
			ProductDTO productDTO = this.saveData(product, requestDTO);
			
			return serviceResponseCreatorCreated.build(ResponseTypeDefinition.PRODUCT, productDTO);
		}

		return serviceResponseCreatorBadRequest.build(ResponseTypeDefinition.PRODUCT, errorListProduct);
	}
	
	private ProductDTO saveData(Product product, RequestUpdateProductDTO requestDTO) {
		
		product.setName(requestDTO.getName());
		product.setCategory(Category.builder().idCategory(requestDTO.getIdCategory()).build());
		product.setVisible(requestDTO.getVisible());
		
		return serviceSave.saveData(product, productRepository, productConverter);
	}
}
