package com.pablo.bakeryManager.dto.product;

import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.annotation.UniqueToCreate;
import com.pablo.bakeryManager.error.ProductErrorMessage;
import com.pablo.bakeryManager.interf.FourthValidation;
import com.pablo.bakeryManager.interf.RequestDTO;
import com.pablo.bakeryManager.interf.SecondValidation;
import com.pablo.bakeryManager.interf.ThirdValidation;
import com.pablo.bakeryManager.model.Product;
import com.pablo.bakeryManager.validator.ValidatorUniqueProduct;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@GroupSequence({
	RequestCreateProductDTO.class,
	SecondValidation.class, 
	ThirdValidation.class, 
	FourthValidation.class
})
public class RequestCreateProductDTO implements RequestDTO {
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idCategory;

	@NotNull
	@NotEmpty(groups = SecondValidation.class)
	@Size(min = 3, max = 100, message = ProductErrorMessage.SIZE_NAME, groups = ThirdValidation.class)
	@UniqueToCreate(property = Product.NAME, uniqueDataValidator = ValidatorUniqueProduct.class, 
		message = ProductErrorMessage.UNIQUE_NAME, groups = FourthValidation.class)
	private String name;

	@SuppressWarnings("unchecked")
	@JsonProperty("product")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> product) {
		
		Map<String, Object> data = (Map<String, Object>) product.get("data");

		name       = (String)  data.get("name");
		idCategory = (Integer) data.get("idCategory");
	}
	
	public Long getIdCategory() {
		return Long.valueOf(this.idCategory);
	}
}
