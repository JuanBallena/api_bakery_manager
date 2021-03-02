package com.pablo.bakeryManager.dominio.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access=AccessLevel.PUBLIC)
@ToString(callSuper=true, includeFieldNames=true)
@Table(name="categories")
@Entity
public class Category {
	
	public static final String ID_CATEGORY = "idCategory";
	public static final String NAME        = "name";
	public static final String VISIBLE     = "visible";
	
	public static final List<String> allowedSorts =  new ArrayList<String>(Arrays.asList(NAME, VISIBLE));
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Category_Id")
	private Long idCategory;

	@Column(name = "Category_Name", unique = true)
	private String name;
	
	@Column(name = "Category_Visible", insertable = false)
	private Boolean visible;
	
	public static final Category create(String name) {
		
		return Category.builder()
				.name(name)
				.build();
	}
}
