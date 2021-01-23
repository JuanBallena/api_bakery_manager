package com.pablo.bakeryManager.dto;

import com.pablo.bakeryManager.interf.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class SettingDTO implements ResponseDTO {

	private Long id;
	private String name;
	private String description;
	private Long value;
}
