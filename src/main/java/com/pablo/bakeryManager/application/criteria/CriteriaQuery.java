package com.pablo.bakeryManager.application.criteria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.pablo.bakeryManager.application.criteria.filtering.Filter;
import com.pablo.bakeryManager.application.criteria.filtering.FilterSpecification;

public class CriteriaQuery<T> {

	public List<Filter> filters = new ArrayList<Filter>();
	public List<Order> orders = new ArrayList<Order>();
	public int page = 0;
	public int size = 0;
	
	public Boolean hasFiltering() {
		
		return this.filters.size() > 0;
	}

	public Boolean hasSorting() {
		
		return this.orders.size() > 0;
	}

	public Boolean hasPaging() {
		
		return this.page >= 0 & this.size > 0;
	}

	public FilterSpecification<T> filterSpecification() {
		
		return new FilterSpecification<T>(this.filters);
	}

	public Sort sort() {
		
		return Sort.by(this.orders);
	}

	public PageRequest pageRequest() {
		
		return PageRequest.of(this.page, this.size);
	}

	public PageRequest pageRequestAndSort() {
		
		return PageRequest.of(this.page, this.size, this.sort());
	}
}
