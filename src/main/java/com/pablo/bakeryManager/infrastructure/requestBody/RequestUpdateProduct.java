package com.pablo.bakeryManager.infrastructure.requestBody;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestUpdateProduct {

	public Integer idCategory;
	public String name;
	public Boolean visible;
	
	@JsonProperty("data")
	private void getJsonProperties(Map<String, Object> data) {

		ObjectMapper mapper = new ObjectMapper();
		RequestUpdateProduct request = mapper.convertValue(data, new TypeReference<RequestUpdateProduct>() { });
		
		idCategory = request.idCategory;
		name       = request.name;
		visible    = request.visible;
	}
}
