package com.pablo.bakeryManager.interf;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface Converter<T,D> {
	
	D toDTO(T t);
	List<D> toDTOList(List<T> TList);
}