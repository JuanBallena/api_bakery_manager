package com.pablo.bakeryManager.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.Unit;

public interface UnitRepository extends CustomRepository<Unit, Long>, JpaSpecificationExecutor<Unit> {

	public Optional<Unit> findByName(String name);
}
