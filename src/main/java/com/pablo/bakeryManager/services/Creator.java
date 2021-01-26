package com.pablo.bakeryManager.services;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.repository.CustomRepository;

@Component
public final class Creator<T,D> {
	
	public <R extends CustomRepository<T, Long> & JpaSpecificationExecutor<T>,
		C extends Converter<T,D>> D saveData(T t, R repository, C converter) {

		repository.save(t);
		repository.refresh(t);		
		return converter.toDTO(t);
	}
}
