package com.pablo.bakeryManager.application.modules.order.orderUpdater;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderUpdaterCommand implements Command {

	private Long idOrder;
	private RequestUpdateOrder requestUpdateOrder;
}
