package com.pablo.bakeryManager.application.modules.order.orderCreator;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreatorCommand implements Command {

	private RequestCreateOrder requestCreateOrder;
}
