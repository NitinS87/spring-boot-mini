package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Vehicle_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vehicle_CategoryDao extends JpaRepository<Vehicle_Category, Long>{

	public Vehicle_Category findByVehicleCategoryId(long vehicleCategoryId);
}