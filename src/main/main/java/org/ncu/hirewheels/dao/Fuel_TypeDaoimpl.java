package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Fuel_Type;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;

import java.util.List;

@Repository
public class Fuel_TypeDaoimpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Fuel_Type> findFuelTypesByFuelTypeIgnoreCase(String fuelType) {
        // Create a JPQL query to find Fuel_Type entities by fuelType (case-insensitive)
        String jpql = "SELECT ft FROM Fuel_Type ft WHERE LOWER(ft.fuelType) = LOWER(:fuelType)";
        TypedQuery<Fuel_Type> query = entityManager.createQuery(jpql, Fuel_Type.class);
        query.setParameter("fuelType", fuelType);
        return query.getResultList();
    }
}