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
@Table(name="order_details")
@Entity
public class OrderDetail {
	
	public static final String PRODUCT = "product";
	
	public static final List<String> allowedSorts =  new ArrayList<String>(Arrays.asList(PRODUCT));
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderDetail_Id")
	private Long idOrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "OrderDetail_IdOrder")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "OrderDetail_IdProduct")
	private Product product;
	
	@Column(name = "OrderDetail_Quantity")
	private Double quantity;
	
	@Column(name = "OrderDetail_Amount")
	private Double amount;
	
	@Column(name = "OrderDetail_Discount")
	private Double discount;
	
	@ManyToOne
	@JoinColumn(name = "OrderDetail_Id003OrderDetailStatus")
	private Parameter status;
}
