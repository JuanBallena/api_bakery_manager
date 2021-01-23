package com.pablo.bakeryManager.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pablo.bakeryManager.model.Setting;

public interface SettingRepository extends CustomRepository<Setting, Long>, JpaSpecificationExecutor<Setting> {

}
