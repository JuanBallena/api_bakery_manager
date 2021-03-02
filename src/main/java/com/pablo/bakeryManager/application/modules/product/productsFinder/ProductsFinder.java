package com.pablo.bakeryManager.application.modules.product.productsFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.application.criteria.paging.Pagination;
import com.pablo.bakeryManager.dominio.models.Product;
import com.pablo.bakeryManager.infrastructure.generic.FindAllGeneric;
import com.pablo.bakeryManager.infrastructure.repository.ProductRepository;

@Service
public class ProductsFinder {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private FindAllGeneric<Product> findAllGeneric;
	
	public Pagination<Product> find(ProductsFinderCriteria criteria) {
		
		return findAllGeneric.find(productRepository, criteria);
	}
}
