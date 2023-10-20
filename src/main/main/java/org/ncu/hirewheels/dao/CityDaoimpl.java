package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.City;

import jakarta.persistence.*;
import java.util.List;

public class CityDaoimpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<City> findCitiesByNameIgnoreCase(String cityName) {
        String jpql = "SELECT c FROM City c WHERE LOWER(c.cityName) = LOWER(:cityName)";
        TypedQuery<City> query = entityManager.createQuery(jpql, City.class);
        query.setParameter("cityName", cityName);
        return query.getResultList();
    }
}