package com.pablo.bakeryManager.services;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.converter.Converter;
import com.pablo.bakeryManager.repository.CustomRepository;

@Component
public class ServiceSave<T,D> {
	
	public <R extends CustomRepository<T, Long> & JpaSpecificationExecutor<T>,
		C extends Converter<T,D>> D postData(T t, R repository, C converter) {

			repository.save(t);
			repository.refresh(t);		
			return converter.toDTO(t);
		
	}
}
