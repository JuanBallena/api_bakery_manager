package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.Customer;

public interface CustomerRepository extends CustomRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	public Customer findByName(String name);
}
