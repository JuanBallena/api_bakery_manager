package com.pablo.bakeryManager.dto.request.orderDetail;

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
	RequestCreateOrderDetailDTO.class,
	SecondValidation.class
})
public class RequestCreateOrderDetailDTO implements RequestDTO {
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idOrder;

	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idProduct;
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Double quantity;
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Double amount;
	
	@NotNull
	private Double discount;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("orderDetail")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> orderDetail) {
		
		Map<String, Object> data = (Map<String, Object>) orderDetail.get("data");

		idOrder   = (Integer) data.get("idOrder");
		idProduct = (Integer) data.get("idProduct");
		quantity  = (Double)  data.get("quantity");
		amount    = (Double)  data.get("amount");
		discount  = (Double)  data.get("discount");
	}
	
	public Long getIdOrder() {
		return Long.valueOf(this.idOrder);
	}
	
	public Long getIdProduct() {
		return Long.valueOf(this.idProduct);
	}
}