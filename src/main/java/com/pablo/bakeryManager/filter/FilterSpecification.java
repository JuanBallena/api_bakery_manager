package com.pablo.bakeryManager.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class FilterSpecification<T> implements Specification<T> {

    private static final long serialVersionUID = 1900581010229669687L;

    private List<Filter> filters;

    public FilterSpecification() {
        this.filters = new ArrayList<Filter>();
    }

    public void addFilters(List<Filter> filters) {
    	
    	for (Filter filter : filters) {
    		this.filters.add(filter);
		}
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        for (Filter filter : this.filters) {   
        	predicates.add(builder.equal(root.get(filter.getPropertyClass()), filter.getParameterValue()));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}


