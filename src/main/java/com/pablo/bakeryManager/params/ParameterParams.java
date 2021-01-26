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
import com.pablo.bakeryManager.model.Parameter;
import com.pablo.bakeryManager.validator.Validator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParameterParams implements Params<Parameter> {

	private Validator validator = new Validator();
	private PageRequestCreator pageAndSortRequest = new PageRequestCreator();

	private Long idParameterType;
	private String sort;
	private String direction;
	private int page;
	private int size;
	
	public ParameterParams() {
		this.idParameterType = 0L;
		this.sort = "";
		this.direction = "";
		this.page = 0;
		this.size = 0;
	}
	
	public Boolean parameterIdParameterTypeIsPositive() {
		return validator.positiveNumber(this.idParameterType);
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
		return this.parameterIdParameterTypeIsPositive();
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
	public FilterSpecification<Parameter> getFilterSpecification() {
		
		FilterSpecification<Parameter> filterSpecification = new FilterSpecification<Parameter>();
		List<Filter> filters = new ArrayList<Filter>();
		
		if (this.parameterIdParameterTypeIsPositive()) filters.add(new Filter(Parameter.PARAMETER_TYPE, this.idParameterType));
				
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