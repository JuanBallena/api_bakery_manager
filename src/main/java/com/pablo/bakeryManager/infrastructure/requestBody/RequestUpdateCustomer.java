package com.pablo.bakeryManager.infrastructure.requestBody;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestUpdateCustomer {

	public String name;
	public String phone;
	public Integer idStatus;
	
	@JsonProperty("data")
	private void getJsonProperties(Map<String, Object> data) {

		ObjectMapper mapper = new ObjectMapper();
		RequestUpdateCustomer request = mapper.convertValue(data, new TypeReference<RequestUpdateCustomer>() { });
		
		name     = request.name;
		phone    = request.phone;
		idStatus = request.idStatus;
	}
}
