package com.pablo.bakeryManager.creator;

import org.springframework.data.domain.PageRequest;

public class PageRequestCreator {

	public static final PageRequest build(int page, int size) {
		return PageRequest.of(page, size);
	}

	public static final PageRequest build(int page, int size, String sort, String direction) {
		return PageRequest.of(page, size, SortCreator.build(sort, direction));
	}
}
