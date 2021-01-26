package com.pablo.bakeryManager.model;

import java.sql.Timestamp;

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
@Table(name="orders")
@Entity
public class Order {

	final static String COLUMN_ID = "Order_Id";
	final static String COLUMN_ID_CUSTOMER = "Order_IdCustomer";
	final static String COLUMN_FULL_PAYMENT = "Order_FullPayment";
	final static String COLUMN_ID_005_TURN = "Order_Id005Turn";
	final static String COLUMN_TIMESTAMP = "Order_Timestamp";
	final static String COLUMN_ID_002_ORDER_STATUS = "Order_Id002OrderStatus";
	
	public static final String CUSTOMER = "customer";
	public static final String TURN = "turn";
	public static final String STATUS = "status";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idOrder;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_CUSTOMER)
	private Customer customer;
	
	@Column(name = COLUMN_FULL_PAYMENT)
	private Double fullPayment;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_005_TURN)
	private Parameter turn;
	
	@Column(name = COLUMN_TIMESTAMP, insertable = false, updatable = false)
	private Timestamp timestamp;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_002_ORDER_STATUS)
	private Parameter status;
}
