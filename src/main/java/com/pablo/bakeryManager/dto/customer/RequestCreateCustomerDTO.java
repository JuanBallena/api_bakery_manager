package com.pablo.bakeryManager.dto.customer;

import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.annotation.UniqueToCreate;
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
	RequestCreateCustomerDTO.class,
	SecondValidation.class, 
	ThirdValidation.class, 
	FourthValidation.class
})
public class RequestCreateCustomerDTO implements RequestDTO {

	@NotNull
	@NotEmpty(groups = SecondValidation.class)
	@Size(min = 3, max = 100, message = CustomerErrorMessage.SIZE_NAME, groups = ThirdValidation.class)
	@UniqueToCreate(property = Customer.NAME, uniqueDataValidator = ValidatorUniqueCustomer.class, 
		message = CustomerErrorMessage.UNIQUE_NAME, groups = FourthValidation.class)
	private String name;
	
	@NotNull
	@Size(max = 20, message = CustomerErrorMessage.SIZE_PHONE, groups = SecondValidation.class)
	private String phone;

	@SuppressWarnings("unchecked")
	@JsonProperty("customer")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> customer) {
		
		Map<String, Object> data = (Map<String, Object>) customer.get("data");

		name  = (String) data.get("name");
		phone = (String) data.get("phone");
	}
}
