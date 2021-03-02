package com.pablo.bakeryManager.infrastructure.requestBody;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestCreateProduct {

	public Integer idCategory;
	public String name;

	@JsonProperty("data")
	private void getJsonProperties(Map<String, Object> data) {
		
		ObjectMapper mapper = new ObjectMapper();
		RequestCreateProduct request = mapper.convertValue(data, new TypeReference<RequestCreateProduct>(){});
		
		idCategory = request.idCategory;
		name       = request.name;
	}
}
