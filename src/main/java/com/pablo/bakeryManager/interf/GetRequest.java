package com.pablo.bakeryManager.interf;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.pablo.bakeryManager.filter.FilterSpecification;

public interface GetRequest<T> {

	public Boolean hasFilterParameters();
	public Boolean hasSortParameters();
	public Boolean hasPagingParameters();
	public Boolean hasFilterAndSortParameters();
	public Boolean hasFilterAndPagingParameters();
	public Boolean hasPagingAndSortParameters();
	public Boolean hasFilterAndPagingAndSortParameters();
	public FilterSpecification<T> getFilterSpecification();
	public PageRequest getPaging();
	public Sort getSort();
	public PageRequest getPagingAndSort();
}
