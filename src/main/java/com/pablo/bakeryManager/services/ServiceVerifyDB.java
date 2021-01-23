package com.pablo.bakeryManager.services;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.repository.CustomRepository;
import com.pablo.bakeryManager.validator.Validator;

@Component
public class ServiceVerifyDB<T> {

	private Validator validator = new Validator();
	
	public <R extends CustomRepository<T, Long> & JpaSpecificationExecutor<T>> T check(Long id, R repository) {
	
		if (validator.notPositiveNumber(id)) {
			return null;
		}
		
		T t = repository.findById(id).orElse(null);
		
		if (t == null) {
			return null;
		}
		
		return t;
	}
}
