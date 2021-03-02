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
@Table(name="customers")
@Entity
public class Customer {
	
	public static final String ID_CUSTOMER = "idCustomer";
	public static final String NAME        = "name";
	public static final String PHONE       = "phone";
	public static final String STATUS      = "status";
	
	public static final String ID_STATUS   = "idStatus"; 
	
	public static final List<String> allowedSorts =  new ArrayList<String>(Arrays.asList(NAME, STATUS));
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_Id")
	private Long idCustomer;
	
	@Column(name = "Customer_Name")
	private String name;
	
	@Column(name = "Customer_Phone")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "Customer_Id001CustomerStatus")
	private Parameter status;
	
	public static final Customer create(String name, String phone) {
		
		return Customer.builder()
				.name(name)
				.phone(phone)
				.status(Parameter.builder().idParameter(ParameterDefinition.PARAMETER_ACTIVE).build())
				.build();
	}
}
