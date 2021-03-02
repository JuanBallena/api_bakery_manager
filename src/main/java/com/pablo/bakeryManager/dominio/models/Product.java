package com.pablo.bakeryManager.dominio.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="products")
@Entity
public class Product {
	
	public static final String ID_PRODUCT  = "idProduct";
	public static final String CATEGORY    = "category";
	public static final String NAME        = "name";
	public static final String VISIBLE     = "visible";
	
	public static final String ID_CATEGORY = "idCategory";
	
	public static final List<String> allowedSorts =  new ArrayList<String>(Arrays.asList(NAME, VISIBLE));
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_Id")
	private Long idProduct;
	
	@ManyToOne
	@JoinColumn(name = "Product_IdCategory")
	private Category category;
	
	@Column(name = "Product_Name")
	private String name;
	
	@Column(name = "Product_Visible", insertable = false)
	private Boolean visible;
	
	public static final Product create(Long idCategory, String name) {
		
		return Product.builder()
				.category(Category.builder().idCategory(idCategory).build())
				.name(name)
				.build();
	}
}
