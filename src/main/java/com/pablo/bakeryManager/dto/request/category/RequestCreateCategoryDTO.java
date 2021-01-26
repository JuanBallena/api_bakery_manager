package com.pablo.bakeryManager.dto.request.category;

import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.annotation.UniqueToCreate;
import com.pablo.bakeryManager.errorMessage.CategoryErrorMessage;
import com.pablo.bakeryManager.interf.FourthValidation;
import com.pablo.bakeryManager.interf.RequestDTO;
import com.pablo.bakeryManager.interf.SecondValidation;
import com.pablo.bakeryManager.interf.ThirdValidation;
import com.pablo.bakeryManager.model.Category;
import com.pablo.bakeryManager.validator.ValidatorUniqueCategory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@GroupSequence({
	RequestCreateCategoryDTO.class,
	SecondValidation.class,
	ThirdValidation.class,
	FourthValidation.class
})
public class RequestCreateCategoryDTO implements RequestDTO {

	@NotNull
	@NotBlank(groups = SecondValidation.class)
	@Size(min = 3, max = 100, message = CategoryErrorMessage.SIZE_NAME, groups = ThirdValidation.class)
	@UniqueToCreate(property = Category.NAME, uniqueDataValidator = ValidatorUniqueCategory.class, 
		message = CategoryErrorMessage.UNIQUE_NAME, groups = FourthValidation.class)
	private String name;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("category")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> category) {
		
		Map<String, Object> data = (Map<String, Object>) category.get("data");

		name = (String) data.get("name");
	}
}
