package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.Order;

public interface OrderRepository extends CustomRepository<Order, Long>, JpaSpecificationExecutor<Order> {

}
