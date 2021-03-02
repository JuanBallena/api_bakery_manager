package com.pablo.bakeryManager.application.criteria.paging;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pagination<T> {

	public List<T> data = new ArrayList<T>();
	public int totalPages = 0;
	
	public Boolean hasData() {
		
		return this.data.size() > 0;
	}
}
