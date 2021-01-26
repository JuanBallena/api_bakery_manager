package com.pablo.bakeryManager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.dto.response.CategoryDTO;
import com.pablo.bakeryManager.interf.Converter;
import com.pablo.bakeryManager.model.Category;

@Component
public class CategoryConverter implements Converter<Category, CategoryDTO> {

	@Override
	public CategoryDTO toDTO(Category c) {

		return CategoryDTO.builder()
				.id(c.getIdCategory())
				.name(c.getName())
				.visible(c.getVisible())
				.build();
	}

	@Override
	public List<CategoryDTO> toDTOList(List<Category> categoryList) {
		
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		categoryList.forEach(category -> categoryDTOList.add(toDTO(category)));
		return categoryDTOList;
	}

}
