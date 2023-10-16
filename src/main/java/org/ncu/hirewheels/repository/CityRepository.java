package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
