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
@Table(name="product_prices")
@Entity
public class ProductPrice {

	final static String COLUMN_ID = "ProductPrice_Id";
	final static String COLUMN_ID_PRODUCT = "ProductPrice_IdProduct";
	final static String COLUMN_ID_UNIT = "ProductPrice_IdUnit";
	final static String COLUMN_PRICE = "ProductPrice_Price";
	final static String COLUMN_VISIBLE = "ProductPrice_Visible";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idProductPrice;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_PRODUCT)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_UNIT)
	private Unit unit;
	
	@Column(name = COLUMN_PRICE)
	private Double price;
	
	@Column(name = COLUMN_VISIBLE, insertable = false)
	private Boolean visible;
}
