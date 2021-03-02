package com.pablo.bakeryManager.dominio.models;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductPrice_Id")
	private Long idProductPrice;
	
	@ManyToOne
	@JoinColumn(name = "ProductPrice_IdProduct")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "ProductPrice_IdUnit")
	private Unit unit;
	
	@Column(name = "ProductPrice_Price")
	private Double price;
	
	@Column(name = "ProductPrice_Visible", insertable = false)
	private Boolean visible;
}
