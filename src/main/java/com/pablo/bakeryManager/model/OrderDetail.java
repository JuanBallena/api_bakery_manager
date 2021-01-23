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
@Table(name="order_details")
@Entity
public class OrderDetail {
	
	final static String COLUMN_ID = "OrderDetail_Id";
	final static String COLUMN_ID_ORDER = "OrderDetail_IdOrder";
	final static String COLUMN_ID_PRODUCT = "OrderDetail_IdProduct";
	final static String COLUMN_QUANTITY = "OrderDetail_Quantity";
	final static String COLUMN_AMOUNT = "OrderDetail_Amount";
	final static String COLUMN_DISCOUNT = "OrderDetail_Discount";
	final static String COLUMN_ID_003_ORDER_DETAIL_STATUS = "OrderDetail_Id003OrderDetailStatus";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idOrderDetail;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_ORDER)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_PRODUCT)
	private Product product;
	
	@Column(name = COLUMN_QUANTITY)
	private Double quantity;
	
	@Column(name = COLUMN_AMOUNT)
	private Double amount;
	
	@Column(name = COLUMN_DISCOUNT)
	private Double discount;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_003_ORDER_DETAIL_STATUS)
	private Parameter status;
}
