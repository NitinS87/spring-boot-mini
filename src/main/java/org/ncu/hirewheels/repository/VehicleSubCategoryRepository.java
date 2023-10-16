package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.Vehicle_Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleSubCategoryRepository extends JpaRepository<Vehicle_Subcategory, Integer> {
    Vehicle_Subcategory findByVehicleSubcategoryNameIgnoreCase(String subCategory);
}
