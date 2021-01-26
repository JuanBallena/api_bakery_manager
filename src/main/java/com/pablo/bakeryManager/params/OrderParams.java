package com.pablo.bakeryManager.params;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.pablo.bakeryManager.creator.PageRequestCreator;
import com.pablo.bakeryManager.creator.SortCreator;
import com.pablo.bakeryManager.filter.Filter;
import com.pablo.bakeryManager.filter.FilterSpecification;
import com.pablo.bakeryManager.interf.Params;
import com.pablo.bakeryManager.model.Order;
import com.pablo.bakeryManager.validator.Validator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderParams implements Params<Order> {

	private Validator validator = new Validator();
	private PageRequestCreator pageAndSortRequest = new PageRequestCreator();

	private Long idCustomer;
	private Long idTurn;
	private Long idStatus;
	private String sort;
	private String direction;
	private int page;
	private int size;
	
	public OrderParams() {
		this.idCustomer = 0L;
		this.idTurn = 0L;
		this.idStatus = 0L;
		this.sort = "";
		this.direction = "";
		this.page = 0;
		this.size = 0;
	}
	
	public Boolean parameterIdCustomerIsPositive() {
		return validator.positiveNumber(this.idCustomer);
	}
	
	public Boolean parameterIdTurnIsPositive() {
		return validator.positiveNumber(this.idTurn);
	}
	
	public Boolean parameterIdStatusIsPositive() {
		return validator.positiveNumber(this.idStatus);
	}
	
	public Boolean parameterSortHasText() {
		return validator.hasText(this.sort);
	}
	
	public Boolean parameterDirectionHasText() {
		return validator.hasText(this.direction);
	}
	
	public Boolean parameterSizeIsPositive() {
		return validator.positiveNumber(this.size);
	}

	@Override
	public Boolean hasFilterParameters() {
		return this.parameterIdCustomerIsPositive() || this.parameterIdTurnIsPositive() || this.parameterIdStatusIsPositive();
	}

	@Override
	public Boolean hasSortParameters() {
		return this.parameterSortHasText() & this.parameterDirectionHasText();
	}

	@Override
	public Boolean hasPagingParameters() {
		return this.parameterSizeIsPositive();
	}

	@Override
	public Boolean hasFilterAndSortParameters() {
		return this.hasFilterParameters() && this.hasSortParameters();
	}

	@Override
	public Boolean hasFilterAndPagingParameters() {
		return this.hasFilterParameters() && this.hasPagingParameters();
	}

	@Override
	public Boolean hasPagingAndSortParameters() {
		return this.hasPagingParameters() && this.hasSortParameters();
	}

	@Override
	public Boolean hasFilterAndPagingAndSortParameters() {
		return this.hasFilterParameters() && this.hasPagingParameters() && this.hasSortParameters();
	}

	@Override
	public FilterSpecification<Order> getFilterSpecification() {
		
		FilterSpecification<Order> filterSpecification = new FilterSpecification<Order>();
		List<Filter> filters = new ArrayList<Filter>();
		
		if (this.parameterIdCustomerIsPositive()) filters.add(new Filter(Order.CUSTOMER, this.idCustomer));
		if (this.parameterIdTurnIsPositive()) filters.add(new Filter(Order.TURN, this.idTurn));
		if (this.parameterIdStatusIsPositive()) filters.add(new Filter(Order.STATUS, this.idStatus));		
		
		filterSpecification.addFilters(filters);
		return filterSpecification;
	}

	@Override
	public PageRequest getPaging() {
		return PageRequestCreator.build(this.page, this.size);
	}

	@Override
	public Sort getSort() {
		return SortCreator.build(this.sort, this.direction);
	}

	@Override
	public PageRequest getPagingAndSort() {
		return PageRequestCreator.build(this.page, this.size, this.sort, this.direction);
	}
}
