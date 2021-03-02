package com.pablo.bakeryManager.infrastructure.requestBody;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestCreateUnit {

	public String name;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("unit")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> unit) {
		
		Map<String, Object> data = (Map<String, Object>) unit.get("data");

		name = (String) data.get("name");
	}
}
