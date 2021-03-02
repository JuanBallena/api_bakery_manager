package com.pablo.bakeryManager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.Order;

public interface OrderRepository extends CustomRepository<Order, Long>, JpaSpecificationExecutor<Order> {

}
