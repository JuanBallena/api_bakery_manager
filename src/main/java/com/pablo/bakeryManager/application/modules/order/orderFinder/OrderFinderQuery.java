package com.pablo.bakeryManager.application.modules.order.orderFinder;

import com.pablo.bakeryManager.dominio.interfaces.Query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderFinderQuery implements Query {

	private Long idOrder;
}
