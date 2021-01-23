package com.pablo.bakeryManager.dto;

import com.pablo.bakeryManager.interf.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ParameterDTO implements ResponseDTO {

	private Long id;
	private String description;
}
