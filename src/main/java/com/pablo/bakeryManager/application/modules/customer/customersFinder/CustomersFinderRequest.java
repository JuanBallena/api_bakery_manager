package com.pablo.bakeryManager.application.modules.customer.customersFinder;

import org.springframework.data.domain.Sort.Order;

import com.pablo.bakeryManager.application.criteria.filtering.Filter;
import com.pablo.bakeryManager.application.criteria.sorting.OrderCreator;
import com.pablo.bakeryManager.application.criteria.sorting.OrderTypes;
import com.pablo.bakeryManager.dominio.models.Customer;
import com.pablo.bakeryManager.infrastructure.requestParams.CustomerRequestParams;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomersFinderRequest {

	private Long idStatus;
	private String orderBy;
	private String orderType;
	private int page;
	private int size;
	
	public static final CustomersFinderRequest create(CustomerRequestParams params) {
		
		return CustomersFinderRequest.builder()
				.idStatus(params.idStatus)
				.orderBy(params.orderBy)
				.orderType(params.orderType)
				.page(params.page)
				.size(params.size)
				.build();
	}
	
	public Boolean idStatusParameterIsValid() {
		
		return this.idStatus > 0;
	}
	
	public Filter filterByStatus() {
		
		return new Filter(Customer.STATUS, this.idStatus);
	}
	
	public Boolean orderByParameterIsValid() {
		
		return Customer.allowedSorts.contains(this.orderBy);
	}
	
	public Boolean orderTypeParameterIsValid() {
		
		return OrderTypes.isAscOrDesc(this.orderType);
	}
	
	public Order order() {
		
		return OrderCreator.build(this.orderBy, this.orderType);
	}
}
