package com.pablo.bakeryManager.dto.order;

import java.util.List;
import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablo.bakeryManager.dto.orderDetail.RequestCreateOrderDetailDTO;
import com.pablo.bakeryManager.interf.RequestDTO;
import com.pablo.bakeryManager.interf.SecondValidation;
import com.pablo.bakeryManager.interf.ThirdValidation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@GroupSequence({
	RequestCreateOrderDTO.class,
	SecondValidation.class,
	ThirdValidation.class
})
public class RequestCreateOrderDTO implements RequestDTO {

	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idCustomer;
	
	@NotNull
	@Positive(groups = SecondValidation.class)
	private Integer idTurn;
	
	@NotNull
	@NotEmpty(groups = SecondValidation.class)
	@Size(min = 1, max = 50, groups = ThirdValidation.class)
	private List<RequestCreateOrderDetailDTO> orderDetailList;
	
	@SuppressWarnings("unchecked")
	@JsonProperty("order")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private void getJsonProperties(Map<String, Object> order) {
		
		Map<String, Object> data = (Map<String, Object>) order.get("data");

		idCustomer      = (Integer)           data.get("idCustomer");
		idTurn          = (Integer)           data.get("idTurn");
		orderDetailList = (List<RequestCreateOrderDetailDTO>) data.get("orderDetailList");
	}
	
	public Long getIdCustomer() {
		return Long.valueOf(this.idCustomer);
	}
	
	public Long getIdTurn() {
		return Long.valueOf(this.idTurn);
	}
	
	public List<RequestCreateOrderDetailDTO> getOrderDetailList() {
		
		ObjectMapper mapper = new ObjectMapper();
		List<RequestCreateOrderDetailDTO> orderDetailList = mapper
				.convertValue(this.orderDetailList, new TypeReference<List<RequestCreateOrderDetailDTO>>() { });
		
		return orderDetailList;
	}
}
