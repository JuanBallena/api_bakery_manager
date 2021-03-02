package com.pablo.bakeryManager.application.serviceResponse;

import com.pablo.bakeryManager.dominio.interfaces.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceResponse implements Response {

	private Integer statusCode    = 0;
	private String  statusMessage = "";
	private String  resourceType  = "";
	private Object  data          = null;
	private Integer pages         = 0;
	private Object  error         = null;
}
