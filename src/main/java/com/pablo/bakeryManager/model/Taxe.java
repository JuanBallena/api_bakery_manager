package com.pablo.bakeryManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="taxes")
@Entity
public class Taxe {

	final static String COLUMN_ID = "Taxe_Id";
	final static String COLUMN_NAME = "Taxe_Name";
	final static String COLUMN_AMOUNT = "Taxe_Amount";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idTaxe;
	
	@Column(name = COLUMN_NAME)
	private String name;
	
	@Column(name = COLUMN_AMOUNT)
	private Double amount;
}
