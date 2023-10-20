package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Vehicle_Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Vehicle_CategoryDaoimpl {
    @PersistenceContext
    private EntityManager entityManager;

    // Implement custom query methods using EntityManager
    public List<Vehicle_Category> findByVehicleCategoryNameIgnoreCase(String vehicleCategoryName) {
        // Implement the query logic here using EntityManager
        return null;  // Replace with your query logic
    }
    
    // Add more custom query methods as needed
}
