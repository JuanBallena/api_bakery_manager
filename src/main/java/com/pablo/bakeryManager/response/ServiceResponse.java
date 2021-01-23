package com.pablo.bakeryManager.response;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.definition.ResponseCodeDefinition;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true, includeFieldNames=true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Component
public class ServiceResponse {

	private String token;
	private Integer responseCode;
    private String responseMessage;
    private String type;
    private Object data;
    private Integer pages;
    private List<Object> errorList;
	private Object exception;
	
	public ServiceResponse() {
		
		this.responseCode = ResponseCodeDefinition.RESPONSE_CODE_INTERNAL_SERVER_ERROR;
		this.responseMessage = ResponseCodeDefinition.RESPONSE_CODE_INTERNAL_SERVER_ERROR_S;
		this.token = "";
		this.type = "";
		this.data = null;
		this.pages = 0;
		this.errorList = new ArrayList<Object>();
		this.exception = null;
	}
	
	public void addResponseOk() {	
		this.responseCode = ResponseCodeDefinition.RESPONSE_CODE_OK;
		this.responseMessage = ResponseCodeDefinition.RESPONSE_CODE_OK_S;
	}
	
	public void addResponseBadRequest() {
		this.responseCode = ResponseCodeDefinition.RESPONSE_CODE_BAD_REQUEST;
		this.responseMessage = ResponseCodeDefinition.RESPONSE_CODE_BAD_REQUEST_S;
	}
	
	public void addResponseNoContent() {
		this.responseCode = ResponseCodeDefinition.RESPONSE_CODE_NO_CONTENT;
		this.responseMessage = ResponseCodeDefinition.RESPONSE_CODE_NO_CONTENT_S;
	}
	
	public void addResponseCreated() {
		this.responseCode = ResponseCodeDefinition.RESPONSE_CODE_CREATED;
		this.responseMessage = ResponseCodeDefinition.RESPONSE_CODE_CREATED_S;
	}
}
