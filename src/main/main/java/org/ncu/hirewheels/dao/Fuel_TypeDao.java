package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Fuel_Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Fuel_TypeDao  extends JpaRepository<Fuel_Type, Long>{
	
	Fuel_Type findByFuelType(String fuelType);
	
	Fuel_Type findByFuelTypeId(Long fuelTypeId);


}