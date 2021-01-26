package com.pablo.bakeryManager.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class ServiceResponse {

	private String token;
	private Integer statusCode;
	private String statusMessage;
	private String type;
	private Object data;
	private Integer pages;
	private List<Object> errorList;
	private Object exception;
	
	public ServiceResponse() {
		
		this.statusCode = 0;
		this.statusMessage = "";
		this.token = "";
		this.type = "";
		this.data = null;
		this.pages = 0;
		this.errorList = new ArrayList<Object>();
		this.exception = null;
	}
}
