package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findVehiclesByAvailabilityStatus(int availabilityStatus);

}
