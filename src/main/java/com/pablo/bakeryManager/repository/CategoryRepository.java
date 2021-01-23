package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.Category;

public interface CategoryRepository extends CustomRepository<Category, Long>, JpaSpecificationExecutor<Category> {

	public Category findByName(String name); 
}
