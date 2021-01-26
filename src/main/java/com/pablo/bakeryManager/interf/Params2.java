package com.pablo.bakeryManager.interf;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.pablo.bakeryManager.filter.FilterSpecification;

public abstract class Params2<T> {

	public abstract Boolean hasFilterParameters();
	public abstract Boolean hasSortParameters();
	public abstract Boolean hasPagingParameters();
	
	public Boolean hasFilterAndSortParameters() {
		
		return this.hasFilterParameters() && this.hasSortParameters();
	}
	public Boolean hasFilterAndPagingParameters() {
		
		return this.hasFilterParameters() && this.hasPagingParameters();
	}
	public Boolean hasPagingAndSortParameters() {
		
		return this.hasPagingParameters() && this.hasSortParameters();
	}
	public Boolean hasFilterAndPagingAndSortParameters() {
		
		return this.hasFilterParameters() && this.hasPagingParameters() && this.hasSortParameters();
	}
	
	public abstract FilterSpecification<T> getFilterSpecification();
	public abstract PageRequest getPaging();
	public abstract Sort getSort();
	public abstract PageRequest getPagingAndSort();
}