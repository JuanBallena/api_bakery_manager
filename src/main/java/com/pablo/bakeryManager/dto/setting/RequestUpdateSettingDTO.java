package com.pablo.bakeryManager.dto.setting;

import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.interf.RequestDTO;
import com.pablo.bakeryManager.interf.SecondValidation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@GroupSequence({
	RequestUpdateSettingDTO.class,
	SecondValidation.class
})
public class RequestUpdateSettingDTO implements RequestDTO {

	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idSetting;
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer value;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("setting")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> setting) {
		
		Map<String, Object> data = (Map<String, Object>) setting.get("data");

		idSetting = (Integer) data.get("idSetting");
		value     = (Integer) data.get("value");
	}
	
	public Long getIdSetting() {
		return Long.valueOf(this.idSetting);
	}
	
	public Long getValue() {
		return Long.valueOf(this.value);
	}
}
