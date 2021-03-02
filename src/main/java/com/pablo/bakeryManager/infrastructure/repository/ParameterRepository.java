package com.pablo.bakeryManager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.Parameter;

public interface ParameterRepository  extends CustomRepository<Parameter, Long>, JpaSpecificationExecutor<Parameter> {

}
