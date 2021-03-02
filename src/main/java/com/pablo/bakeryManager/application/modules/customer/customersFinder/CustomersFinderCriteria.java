package com.pablo.bakeryManager.application.modules.customer.customersFinder;

import com.pablo.bakeryManager.application.criteria.CriteriaQuery;
import com.pablo.bakeryManager.dominio.models.Customer;

public class CustomersFinderCriteria extends CriteriaQuery<Customer> {

	public CustomersFinderCriteria(CustomersFinderRequest request) {
		
		if (request.idStatusParameterIsValid()) {
			this.filters.add(request.filterByStatus());
		}
		
		if (request.orderByParameterIsValid() & request.orderTypeParameterIsValid()) {
			this.orders.add(request.order());
		}
		
		this.page = request.getPage();
		this.size = request.getSize();
	}
}
