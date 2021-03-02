package com.pablo.bakeryManager.application.modules.setting;

import lombok.Builder;

@Builder
public class SettingResponse {

	public Long   id;
	public String name;
	public String description;
	public Long   value;
}
