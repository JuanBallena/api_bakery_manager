package com.pablo.bakeryManager.application.modules.category.categoryUpdater;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestUpdateCategory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryUpdaterCommand implements Command {

	public Long idCategory;
	public RequestUpdateCategory request;
}
