package com.pablo.bakeryManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="parameter_types")
@Entity
public class ParameterType {

	final static String COLUMN_ID = "ParameterType_Id";
	final static String COLUMN_DESCRIPTION = "ParameterType_Description";
	
	@Id
	@Column(name = COLUMN_ID)
	private Long idParameterType;
	
	@Column(name = COLUMN_DESCRIPTION)
	private String description;
}
