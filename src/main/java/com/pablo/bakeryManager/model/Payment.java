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
@Table(name="payments")
@Entity
public class Payment {

	final static String COLUMN_ID = "Payment_Id";
	final static String COLUMN_ID_ORDER = "Payment_IdOrder";
	final static String COLUMN_AMOUNT = "Payment_Amount";
	final static String COLUMN_RESIDUE = "Payment_Residue";
	final static String COLUMN_TIMESTAMP = "Payment_Timestamp";
	final static String COLUMN_ID_004_PAYMENT_STATUS = "Payment_Id004PaymentStatus";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idPayment;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_ORDER)
	private Order order;
	
	@Column(name = COLUMN_AMOUNT)
	private Double amount;
	
	@Column(name = COLUMN_RESIDUE)
	private Double residue;
	
	@Column(name = COLUMN_TIMESTAMP, insertable = false)
	private Timestamp timestamp;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_004_PAYMENT_STATUS, insertable = false)
	private Parameter status;
}
