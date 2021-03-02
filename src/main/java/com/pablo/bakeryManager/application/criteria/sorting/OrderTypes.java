package com.pablo.bakeryManager.application.criteria.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderTypes {

	public static final Boolean isAscOrDesc(String sortDirection) {
		
		return new ArrayList<String>(Arrays.asList("asc", "desc")).contains(sortDirection);
	}
}
