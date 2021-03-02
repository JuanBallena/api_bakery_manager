package com.pablo.bakeryManager.application.modules.category.categoryCreator;

import com.pablo.bakeryManager.dominio.interfaces.Command;
import com.pablo.bakeryManager.infrastructure.requestBody.RequestCreateCategory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryCreatorCommand implements Command {

	public RequestCreateCategory request;
}
