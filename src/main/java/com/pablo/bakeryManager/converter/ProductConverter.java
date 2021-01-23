package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.CategoryDTO;
import com.pablo.bakeryManager.dto.ProductDTO;
import com.pablo.bakeryManager.model.Product;

@Component
public class ProductConverter implements Converter<Product, ProductDTO> {

	@Override
	public ProductDTO toDTO(Product p) {
		
		return ProductDTO.builder()
				.id(p.getIdProduct())
				.category(CategoryDTO.builder()
						.id(p.getCategory().getIdCategory())
						.name(p.getCategory().getName())
						.build())
				.name(p.getName())
				.visible(p.getVisible())
				.build();
	}

	@Override
	public List<ProductDTO> toDTOList(List<Product> products) {
		
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		products.forEach(product -> productDTOList.add(toDTO(product)));
		return productDTOList;
	}

}
