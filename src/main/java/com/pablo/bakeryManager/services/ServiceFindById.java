package com.pablo.bakeryManager.services;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.converter.Converter;
import com.pablo.bakeryManager.repository.CustomRepository;
import com.pablo.bakeryManager.validator.Validator;

@Component
public class ServiceFindById<T,D> {
	
	private Validator validator = new Validator();

	public <R extends CustomRepository<T, Long> & JpaSpecificationExecutor<T>,
		C extends Converter<T,D>> D getData(Long id, R repository, C converter) {
		
		if (validator.notPositiveNumber(id)) return null;

		T t = repository.findById(id).orElse(null);
		
		if (validator.isNull(t)) return null;
		
		return converter.toDTO(t);
	}
}
