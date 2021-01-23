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
@Table(name="users")
@Entity
public class User {
	
	final static String COLUMN_ID = "User_Id";
	final static String COLUMN_USERNAME = "User_Username";
	final static String COLUMN_PASSWORD = "User_Password";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long idUser;

	@Column(name = COLUMN_USERNAME)
	private String username;
	
	@Column(name = COLUMN_PASSWORD)
	private String password;
}
