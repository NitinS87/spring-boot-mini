package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Vehicle_Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vehicle_SubcategoryDao extends JpaRepository<Vehicle_Subcategory, Long>{

	public Vehicle_Subcategory findByVehicleSubcategoryId(long vehicleSubcategoryId);
	

}