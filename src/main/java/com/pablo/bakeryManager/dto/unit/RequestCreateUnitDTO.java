package com.pablo.bakeryManager.dto.unit;

import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.annotation.UniqueToCreate;
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
	RequestCreateUnitDTO.class,
	SecondValidation.class, 
	ThirdValidation.class, 
	FourthValidation.class
})
public class RequestCreateUnitDTO implements RequestDTO {

	@NotNull
	@NotBlank(groups = SecondValidation.class)
	@Size(min = 3, max = 100, message = UnitErrorMessage.SIZE_NAME, groups = ThirdValidation.class)
	@UniqueToCreate(property = Unit.NAME, uniqueDataValidator = ValidatorUniqueUnit.class, 
		message = UnitErrorMessage.UNIQUE_NAME, groups = FourthValidation.class)
	private String name;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("unit")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> unit) {
		
		Map<String, Object> data = (Map<String, Object>) unit.get("data");

		name = (String) data.get("name");
	}
}
