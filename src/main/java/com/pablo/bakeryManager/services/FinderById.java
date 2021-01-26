package com.pablo.bakeryManager.services;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.repository.CustomRepository;

@Component
public final class FinderById<T,D> {

	public <R extends CustomRepository<T, Long> & JpaSpecificationExecutor<T>,
		C extends Converter<T,D>> D getData(Long id, R repository, C converter) {
		
		if (id <= 0) return null;

		T t = repository.findById(id).orElse(null);
		
		if (t == null) return null;
		
		return converter.toDTO(t);
	}
}
