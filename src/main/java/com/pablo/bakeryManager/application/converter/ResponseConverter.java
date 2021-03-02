package com.pablo.bakeryManager.application.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ResponseConverter<T,R> {

	public abstract R convert(T t);
	
	public List<R> convertList(List<T> list) {
		
		return list.stream().map(t -> convert(t)).collect(Collectors.toList());
	}
}
