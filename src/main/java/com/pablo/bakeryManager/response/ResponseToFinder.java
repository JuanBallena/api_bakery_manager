package com.pablo.bakeryManager.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseToFinder {

	@Autowired
	private ServiceResponseCreatorNoContent serviceResponseCreatorNoContent;
	
	@Autowired
	private ServiceResponseCreatorOk serviceResponseCreatorOk;

	public ServiceResponse dispatch(String responseType, PageResponse pageResponse) {
		
		return (pageResponse.hasData())
				? serviceResponseCreatorOk.build(responseType, pageResponse)
				: serviceResponseCreatorNoContent.build(responseType, pageResponse);
	}
}
