package com.pablo.bakeryManager.infrastructure.requestParams;

import lombok.Setter;

@Setter
public class ParameterRequestParams {

	public Long idParameterType;
	public int page;
	public int size;
	
	public ParameterRequestParams() {
		
		this.idParameterType = 0L;
		this.page            = 0;
		this.size            = 0;
	}
}
