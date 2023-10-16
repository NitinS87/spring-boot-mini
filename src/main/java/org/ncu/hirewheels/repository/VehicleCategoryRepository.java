package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.Vehicle_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryRepository extends JpaRepository<Vehicle_Category, Integer> {
    Vehicle_Category findVehicle_CategoryByVehicleCategoryNameIgnoreCase(String vehicleCategoryName);
}
