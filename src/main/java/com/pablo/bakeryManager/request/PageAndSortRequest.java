package com.pablo.bakeryManager.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageAndSortRequest {

	public PageRequest getPaging(int page, int size) {
		return PageRequest.of(page, size);
	}

	public Sort getSort(String sort, String direction) {
		if (direction.equals("asc")) return Sort.by(Sort.Direction.ASC, sort);
		if (direction.equals("desc")) return Sort.by(Sort.Direction.DESC, sort);
		return null;
	}

	public PageRequest getPagingAndSort(int page, int size, String sort, String direction) {
		return PageRequest.of(page, size, this.getSort(sort, direction));
	}
}
