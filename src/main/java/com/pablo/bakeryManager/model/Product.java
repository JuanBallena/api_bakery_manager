package com.pablo.bakeryManager.model;

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

	final static String COLUMN_ID = "Product_Id";
	final static String COLUMN_ID_CATEGORY = "Product_IdCategory";
	final static String COLUMN_NAME = "Product_Name";
	final static String COLUMN_VISIBLE = "Product_Visible";
	
	public final static String CATEGORY = "category";
	public final static String NAME = "name";
	public final static String VISIBLE = "visible";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idProduct;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_CATEGORY)
	private Category category;
	
	@Column(name = COLUMN_NAME)
	private String name;
	
	@Column(name = COLUMN_VISIBLE, insertable = false)
	private Boolean visible;
}
