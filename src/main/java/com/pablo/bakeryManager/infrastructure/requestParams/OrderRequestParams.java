package com.pablo.bakeryManager.infrastructure.requestParams;

import lombok.Setter;

@Setter
public class OrderRequestParams {

	public Long idCustomer;
	public Long idTurn;
	public Long idStatus;
	public String orderBy;
	public String orderType;
	public int page;
	public int size;
	
	public OrderRequestParams() {
		
		this.idCustomer = 0L;
		this.idTurn     = 0L;
		this.idStatus   = 0L;
		this.orderBy    = "";
		this.orderType  = "";
		this.page       = 0;
		this.size       = 0;
	}
}
