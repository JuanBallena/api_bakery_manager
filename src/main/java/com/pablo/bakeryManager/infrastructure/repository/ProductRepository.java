package com.pablo.bakeryManager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.Product;

public interface ProductRepository extends CustomRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	public Product findByName(String name);
}
