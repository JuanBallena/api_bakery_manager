package com.pablo.bakeryManager.application.criteria.filtering;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FilterSpecification<T> implements Specification<T> {

    private static final long serialVersionUID = 1900581010229669687L;
    
    private List<Filter> filters = new ArrayList<Filter>();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<Predicate>();

        for (Filter filter : this.filters) {   
        	
        	predicates.add(builder.equal(root.get(filter.getProperty()), filter.getValue()));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}


