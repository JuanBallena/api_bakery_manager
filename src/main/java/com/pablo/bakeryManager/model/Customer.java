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
@Table(name="customers")
@Entity
public class Customer {

	final static String COLUMN_ID = "Customer_Id";
	final static String COLUMN_NAME = "Customer_Name";
	final static String COLUMN_PHONE = "Customer_Phone";
	final static String COLUMN_ID_001_CUSTOMER_STATUS = "Customer_Id001CustomerStatus";
	
	public final static String NAME = "name";
	public final static String PHONE = "phone";
	public final static String STATUS = "status";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idCustomer;
	
	@Column(name = COLUMN_NAME)
	private String name;
	
	@Column(name = COLUMN_PHONE)
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_001_CUSTOMER_STATUS)
	private Parameter status;
}
