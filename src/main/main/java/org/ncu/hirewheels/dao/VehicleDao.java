package org.ncu.hirewheels.dao;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.Vehicle_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle, Long>{
	Vehicle findByVehicleId(long vehicleId);
	
	List<Vehicle> findByVehicleSubcategoryVehicleCategory(Vehicle_Category vehicleCategory);

}