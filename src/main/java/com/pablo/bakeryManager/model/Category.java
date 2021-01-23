package com.pablo.bakeryManager.model;

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

	final static String COLUMN_ID = "Category_Id";
	final static String COLUMN_NAME = "Category_Name";
	final static String COLUMN_VISIBLE = "Category_Visible";
	
	public static final String NAME = "name";
	public static final String VISIBLE = "visible";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idCategory;

	@Column(name = COLUMN_NAME)
	private String name;
	
	@Column(name = COLUMN_VISIBLE, insertable = false)
	private Boolean visible;
}
