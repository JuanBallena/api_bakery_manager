package com.pablo.bakeryManager.dto.request.order;

import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pablo.bakeryManager.interf.RequestDTO;
import com.pablo.bakeryManager.interf.SecondValidation;
import com.pablo.bakeryManager.interf.ThirdValidation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@GroupSequence({
	RequestUpdateOrderDTO.class,
	SecondValidation.class,
	ThirdValidation.class
})
public class RequestUpdateOrderDTO implements RequestDTO {
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idOrder;

	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idCustomer;
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idTurn;
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idStatus;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("order")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> order) {
		
		Map<String, Object> data = (Map<String, Object>) order.get("data");

		idOrder    = (Integer) data.get("idOrder");
		idCustomer = (Integer) data.get("idCustomer");
		idTurn     = (Integer) data.get("idTurn");
		idStatus   = (Integer) data.get("idStatus");
	}
	
	public Long getIdOrder() {
		return Long.valueOf(this.idOrder);
	}
	
	public Long getIdCustomer() {
		return Long.valueOf(this.idCustomer);
	}
	
	public Long getIdTurn() {
		return Long.valueOf(this.idTurn);
	}
	
	public Long getIdStatus() {
		return Long.valueOf(this.idStatus);
	}
}
