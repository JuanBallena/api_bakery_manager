package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.Parameter;

public interface ParameterRepository  extends CustomRepository<Parameter, Long>, JpaSpecificationExecutor<Parameter> {

}
