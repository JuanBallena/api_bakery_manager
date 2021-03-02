package com.pablo.bakeryManager.infrastructure.requestBody;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestUpdateCategory {

	public String name;
	public Boolean visible;
	
	@JsonProperty("data")
	private void getJsonProperties(Map<String, Object> data) {

		ObjectMapper mapper = new ObjectMapper();
		RequestUpdateCategory request = mapper.convertValue(data, new TypeReference<RequestUpdateCategory>() { });
		
		name       = request.name;
		visible    = request.visible;	
	}
}
