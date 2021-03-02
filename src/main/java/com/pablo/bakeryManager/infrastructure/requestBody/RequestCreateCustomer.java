package com.pablo.bakeryManager.infrastructure.requestBody;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestCreateCustomer {

	public String name;
	public String phone;

	@JsonProperty("data")
	private void getJsonProperties(Map<String, Object> data) {
		
		ObjectMapper mapper = new ObjectMapper();
		RequestCreateCustomer request = mapper.convertValue(data, new TypeReference<RequestCreateCustomer>(){});
		
		name  = request.name;
		phone = request.phone;
	}
}
