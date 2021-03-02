package com.pablo.bakeryManager.application.modules.order.ordersFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;
import com.pablo.bakeryManager.infrastructure.requestParams.OrderRequestParams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrdersFinderQuery implements Query {

	private OrderRequestParams request;
}
