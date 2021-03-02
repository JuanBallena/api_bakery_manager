package com.pablo.bakeryManager.infrastructure.requestParams;

import lombok.Setter;

@Setter
public class CustomerRequestParams {

	public String name = "";
	public Long idStatus = 0L;
	public String orderBy = "";
	public String orderType = "";
	public int page = 0;
	public int size = 0;
}
