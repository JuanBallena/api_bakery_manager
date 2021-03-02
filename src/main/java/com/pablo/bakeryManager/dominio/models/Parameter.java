package com.pablo.bakeryManager.dominio.models;

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

	public static final String PARAMETER_TYPE = "parameterType";
	
	@Id
	@Column(name = "Parameter_Id")
	private Long idParameter;
	
	@ManyToOne
	@JoinColumn(name = "Parameter_IdParameterType")
	private ParameterType parameterType;
	
	@Column(name = "Parameter_Description")
	private String description;
}
