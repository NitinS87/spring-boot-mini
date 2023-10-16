package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.Fuel_Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<Fuel_Type, Integer> {
    Fuel_Type findByFuelTypeIgnoreCase(String fuelType);
}
