package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.Unit;

public interface UnitRepository extends CustomRepository<Unit, Long>, JpaSpecificationExecutor<Unit> {

	public Unit findByName(String name);
}
