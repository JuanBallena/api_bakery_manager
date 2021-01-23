package com.pablo.bakeryManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="parameters")
@Entity
public class Parameter {

	final static String COLUMN_ID = "Parameter_Id";
	final static String COLUMN_ID_PARAMETER_TYPE = "Parameter_IdParameterType";
	final static String COLUMN_DESCRIPTION = "Parameter_Description";
	
	public static final String PARAMETER_TYPE = "parameterType";
	
	@Id
	@Column(name = COLUMN_ID)
	private Long idParameter;
	
	@ManyToOne
	@JoinColumn(name = COLUMN_ID_PARAMETER_TYPE)
	private ParameterType parameterType;
	
	@Column(name = COLUMN_DESCRIPTION)
	private String description;
}
