package com.pablo.bakeryManager.services.orderDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.bakeryManager.dto.orderDetail.RequestCreateOrderDetailDTO;

@Service
public class ServiceCreateOrderDetailList {

	@Autowired
	private ServiceCreateOrderDetail serviceCreateOrderDetail;
	
	public void postData(Long idOrder, List<RequestCreateOrderDetailDTO> requestDTOList) {
		
		for (RequestCreateOrderDetailDTO requestDTO : requestDTOList) {
			
			serviceCreateOrderDetail.postData(idOrder, requestDTO);
		}
	}
}
