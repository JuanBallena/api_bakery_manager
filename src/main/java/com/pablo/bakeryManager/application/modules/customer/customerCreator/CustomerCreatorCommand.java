package com.pablo.bakeryManager.application.modules.customer.customerCreator;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateCustomer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerCreatorCommand implements Command {

	public RequestCreateCustomer request;
}
