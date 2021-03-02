package com.pablo.bakeryManager.application.modules.orderDetail;

import com.pablo.bakeryManager.application.modules.order.OrderResponse;
import com.pablo.bakeryManager.application.modules.parameter.ParameterResponse;
import com.pablo.bakeryManager.application.modules.product.ProductResponse;

import lombok.Builder;

@Builder
public class OrderDetailResponse {

	public Long              id;
	public OrderResponse     order;
	public ProductResponse   product;
	public Double            quantity;
	public Double            amount;
	public Double            discount;
	public ParameterResponse status;
}
