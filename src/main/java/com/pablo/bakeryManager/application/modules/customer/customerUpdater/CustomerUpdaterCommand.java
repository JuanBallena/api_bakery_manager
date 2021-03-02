package com.pablo.bakeryManager.application.modules.customer.customerUpdater;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateCustomer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerUpdaterCommand implements Command {

	public Long idCustomer;
	public RequestUpdateCustomer request;
}
