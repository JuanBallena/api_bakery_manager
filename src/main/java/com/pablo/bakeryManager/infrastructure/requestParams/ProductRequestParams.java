package com.pablo.bakeryManager.infrastructure.requestParams;

import lombok.Setter;

@Setter
public class ProductRequestParams {

	public Long idCategory = 0L;
	public Boolean visible = null;
	public String orderBy = "";
	public String orderType = "";
	public int page = 0;
	public int size = 0;
}
