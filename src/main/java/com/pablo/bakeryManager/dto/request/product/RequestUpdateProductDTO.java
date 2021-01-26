package com.pablo.bakeryManager.dto.request.product;

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
import com.pablo.bakeryManager.errorMessage.ProductErrorMessage;
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
	RequestUpdateProductDTO.class,
	SecondValidation.class, 
	ThirdValidation.class, 
	FourthValidation.class
})
public class RequestUpdateProductDTO implements RequestDTO {
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idProduct;

	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idCategory;

	@NotNull
	@NotEmpty(groups = SecondValidation.class)
	@Size(min = 3, max = 100, message = ProductErrorMessage.SIZE_NAME, groups = ThirdValidation.class)
	private String name;
	
	@UniqueToUpdate(property = Product.NAME, uniqueDataValidator = ValidatorUniqueProduct.class, 
			message = ProductErrorMessage.UNIQUE_NAME, groups = FourthValidation.class)
	private Map<String, Object> getName_() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", this.idProduct);
		map.put("value", this.name);
		
		return map;
	}
	
	@NotNull
	@TrueOrFalse(groups = SecondValidation.class)
	private Boolean visible;

	@SuppressWarnings("unchecked")
	@JsonProperty("product")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> product) {
		
		Map<String, Object> data = (Map<String, Object>) product.get("data");

		idProduct  = (Integer) data.get("idProduct");
		name       = (String)  data.get("name");
		idCategory = (Integer) data.get("idCategory");
		visible    = (Boolean) data.get("visible");
	}
	
	public Long getIdProduct() {
		return Long.valueOf(this.idProduct);
	}
	
	public Long getIdCategory() {
		return Long.valueOf(this.idCategory);
	}
}
