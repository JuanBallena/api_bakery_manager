package com.pablo.bakeryManager.dto.unit;

import java.util.HashMap;
import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.annotation.TrueOrFalse;
import com.pablo.bakeryManager.annotation.UniqueToUpdate;
import com.pablo.bakeryManager.error.UnitErrorMessage;
import com.pablo.bakeryManager.interf.FourthValidation;
import com.pablo.bakeryManager.interf.RequestDTO;
import com.pablo.bakeryManager.interf.SecondValidation;
import com.pablo.bakeryManager.interf.ThirdValidation;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.validator.ValidatorUniqueUnit;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@GroupSequence({
	RequestUpdateUnitDTO.class,
	SecondValidation.class,
	ThirdValidation.class,
	FourthValidation.class
})
public class RequestUpdateUnitDTO implements RequestDTO {
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idUnit;
	
	@NotNull
	@NotEmpty(groups = SecondValidation.class)
	@Size(min = 3, max = 100, message = UnitErrorMessage.SIZE_NAME, groups = ThirdValidation.class)
	private String name;
	
	@UniqueToUpdate(property = Unit.NAME, uniqueDataValidator = ValidatorUniqueUnit.class, 
		message = UnitErrorMessage.UNIQUE_NAME, groups = FourthValidation.class)
	private Map<String, Object> getName_() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", this.idUnit);
		map.put("value", this.name);
		
		return map;
	}
	
	@NotNull
	@TrueOrFalse(groups = SecondValidation.class)
	private Boolean visible;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("unit")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> unit) {
	
		Map<String, Object> data = (Map<String, Object>) unit.get("data");
		
		idUnit     = (Integer) data.get("idUnit");
		name       = (String)  data.get("name");
		visible    = (Boolean) data.get("visible");
	}
	
	public Long getIdUnit() {
		return Long.valueOf(this.idUnit);
	}
}
