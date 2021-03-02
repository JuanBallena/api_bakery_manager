package com.pablo.bakeryManager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.Customer;

public interface CustomerRepository extends CustomRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	public Customer findByName(String name);
}
