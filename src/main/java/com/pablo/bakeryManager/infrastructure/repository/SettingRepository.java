package com.pablo.bakeryManager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.dominio.models.Setting;

public interface SettingRepository extends CustomRepository<Setting, Long>, JpaSpecificationExecutor<Setting> {

}
