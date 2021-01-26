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
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.validator.Validator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnitParams implements Params<Unit> {

	private Validator validator = new Validator();
	private PageRequestCreator pageAndSortRequest = new PageRequestCreator();

	private String name;
	private Boolean visible;
	private String sort;
	private String direction;
	private int page;
	private int size;
	
	public UnitParams() {
		this.name = "";
		this.visible = null;
		this.sort = "";
		this.direction = "";
		this.page = 0;
		this.size = 0;
	}
	
	public Boolean parameterNameHasText() {
		return validator.hasText(this.name);
	}
	
	public Boolean parameterVisibleNotNull() {
		return validator.notNull(this.visible);
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
		return this.parameterNameHasText() || this.parameterVisibleNotNull();
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
	public FilterSpecification<Unit> getFilterSpecification() {
		
		FilterSpecification<Unit> filterSpecification = new FilterSpecification<Unit>();
		List<Filter> filters = new ArrayList<Filter>();
		
		if (this.parameterNameHasText()) filters.add(new Filter(Unit.NAME, this.name));
		if (this.parameterVisibleNotNull()) filters.add(new Filter(Unit.VISIBLE, this.visible));		
		
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
