package com.pablo.bakeryManager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.Category;

public interface CategoryRepository extends CustomRepository<Category, Long>, JpaSpecificationExecutor<Category> {

	public Category findByName(String name);
}
