package com.pablo.bakeryManager.dto.customer;

import java.util.HashMap;
import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.annotation.UniqueToUpdate;
import com.pablo.bakeryManager.error.CustomerErrorMessage;
import com.pablo.bakeryManager.interf.FourthValidation;
import com.pablo.bakeryManager.interf.RequestDTO;
import com.pablo.bakeryManager.interf.SecondValidation;
import com.pablo.bakeryManager.interf.ThirdValidation;
import com.pablo.bakeryManager.model.Customer;
import com.pablo.bakeryManager.validator.ValidatorUniqueCustomer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@GroupSequence({
	RequestUpdateCustomerDTO.class,
	SecondValidation.class, 
	ThirdValidation.class, 
	FourthValidation.class
})
public class RequestUpdateCustomerDTO implements RequestDTO {
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idCustomer;

	@NotNull
	@NotEmpty(groups = SecondValidation.class)
	@Size(min = 3, max = 100, groups = ThirdValidation.class)
	private String name;
	
	@UniqueToUpdate(property = Customer.NAME, message = CustomerErrorMessage.UNIQUE_NAME, 
		uniqueDataValidator = ValidatorUniqueCustomer.class, groups = FourthValidation.class)
	private Map<String, Object> getName_() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", this.idCustomer);
		map.put("value", this.name);
		
		return map;
	}
	
	@NotNull
	@Size(max = 20, message = CustomerErrorMessage.SIZE_PHONE, groups = SecondValidation.class)
	private String phone;
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idStatus;

	@SuppressWarnings("unchecked")
	@JsonProperty("customer")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> customer) {
		
		Map<String, Object> data = (Map<String, Object>) customer.get("data");

		idCustomer = (Integer) data.get("idCustomer");
		name       = (String)  data.get("name");
		phone      = (String)  data.get("phone");
		idStatus   = (Integer) data.get("idStatus");
	}
	
	public Long getIdCustomer() {
		return Long.valueOf(this.idCustomer);
	}
	
	public Long getIdStatus() {
		return Long.valueOf(this.idStatus);
	}
}
