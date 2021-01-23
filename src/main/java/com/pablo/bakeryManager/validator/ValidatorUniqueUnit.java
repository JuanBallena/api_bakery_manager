package com.pablo.bakeryManager.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pablo.bakeryManager.interf.UniqueDataValidator;
import com.pablo.bakeryManager.model.Unit;
import com.pablo.bakeryManager.repository.UnitRepository;

@Component
public class ValidatorUniqueUnit implements UniqueDataValidator {

	private Validator validator = new Validator();
	
	@Autowired
	private UnitRepository unitRepository;

	@Override
	public boolean isValidToCreate(String propertyClass, Object value) {
		
		Unit unit = findUnit(propertyClass, value);
		return validator.isNull(unit);
	}

	@Override
	public boolean isValidToUpdate(String propertyClass, Object value, Long id) {
		
		Unit unit = findUnit(propertyClass, value);
		
		if (validator.notNull(unit)) {
			
			return unit.getIdUnit().equals(id);
		}
		return true;	
	}
	
	private Unit findUnit(String propertyClass, Object value) {
		
		switch (propertyClass) {
			case Unit.NAME:
				return unitRepository.findByName(value.toString());
			default:
				return null;
		}
	}
}
