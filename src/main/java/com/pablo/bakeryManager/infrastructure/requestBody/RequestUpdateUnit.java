package com.pablo.bakeryManager.infrastructure.requestBody;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestUpdateUnit {

	public Integer idUnit;
	public String name;
	public Boolean visible;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("unit")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> unit) {
	
		Map<String, Object> data = (Map<String, Object>) unit.get("data");
		
		idUnit  = (Integer) data.get("idUnit");
		name    = (String)  data.get("name");
		visible = (Boolean) data.get("visible");
	}
}
