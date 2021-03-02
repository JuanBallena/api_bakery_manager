package com.pablo.bakeryManager.infrastructure.requestParams;

import lombok.Setter;

@Setter
public class UnitRequestParams {

	public String  name;
	public Boolean visible;
	public String orderBy;
	public String orderType;
	public int page;
	public int size;
	
	public UnitRequestParams() {
		
		this.name      = "";
		this.visible   = null;
		this.orderBy   = "";
		this.orderType = "";
		this.page      = 0;
		this.size      = 0;
	}
}
