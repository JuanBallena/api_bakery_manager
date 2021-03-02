package com.pablo.bakeryManager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.OrderDetail;

public interface OrderDetailRepository extends CustomRepository<OrderDetail, Long>, JpaSpecificationExecutor<OrderDetail> {

}
