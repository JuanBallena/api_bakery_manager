package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.Product;

public interface ProductRepository extends CustomRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	public Product findByName(String name);
}
