package com.pablo.bakeryManager.dominio.models;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Payment_Id")
	private Long idPayment;
	
	@ManyToOne
	@JoinColumn(name = "Payment_IdOrder")
	private Order order;
	
	@Column(name = "Payment_Amount")
	private Double amount;
	
	@Column(name = "Payment_Residue")
	private Double residue;
	
	@Column(name = "Payment_Timestamp", insertable = false)
	private Timestamp timestamp;
	
	@ManyToOne
	@JoinColumn(name = "Payment_Id004PaymentStatus", insertable = false)
	private Parameter status;
}
