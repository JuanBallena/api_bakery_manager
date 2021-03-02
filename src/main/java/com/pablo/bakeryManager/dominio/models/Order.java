package com.pablo.bakeryManager.dominio.models;

import java.sql.Timestamp;
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
@Table(name="orders")
@Entity
public class Order {
	
	public static final String CUSTOMER = "customer";
	public static final String TURN     = "turn";
	public static final String STATUS   = "status";
	
	public static final List<String> allowedSorts =  new ArrayList<String>(Arrays.asList(TURN, STATUS));
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Order_Id")
	private Long idOrder;
	
	@ManyToOne
	@JoinColumn(name = "Order_IdCustomer")
	private Customer customer;
	
	@Column(name = "Order_FullPayment")
	private Double fullPayment;
	
	@ManyToOne
	@JoinColumn(name = "Order_Id005Turn")
	private Parameter turn;
	
	@Column(name = "Order_Timestamp", insertable = false, updatable = false)
	private Timestamp timestamp;
	
	@ManyToOne
	@JoinColumn(name = "Order_Id002OrderStatus")
	private Parameter status;
}
