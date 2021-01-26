package com.pablo.bakeryManager.creator;

import org.springframework.data.domain.Sort;

public class SortCreator {

	public static final Sort build(String sort, String direction) {
		
		if (direction.equals("asc")) {
			return Sort.by(Sort.Direction.ASC, sort);
		}
		
		if (direction.equals("desc")) {
			return Sort.by(Sort.Direction.DESC, sort);
		}
		
		return null;
	}
}
