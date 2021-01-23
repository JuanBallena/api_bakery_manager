package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.OrderDetail;

public interface OrderDetailRepository extends CustomRepository<OrderDetail, Long>, JpaSpecificationExecutor<OrderDetail> {

}
