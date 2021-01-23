package com.pablo.bakeryManager.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Filter {

	private String propertyClass;
	private Object parameterValue;
}
