package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Location;

import jakarta.persistence.*;
import java.util.List;

public class LocationDaoimpl {
    @PersistenceContext
    private EntityManager entityManager;

//    public List<Location> findLocationsByNameIgnoreCase(String locationName) {
//        String jpql = "SELECT l FROM Location l WHERE LOWER(l.locationName) = LOWER(:locationName)";
//        TypedQuery<Location> query = entityManager.createQuery(jpql, Location.class);
//        query.setParameter("locationName", locationName);
//        return query.getResultList();
//    }
}