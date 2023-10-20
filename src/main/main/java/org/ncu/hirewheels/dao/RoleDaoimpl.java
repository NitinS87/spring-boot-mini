package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoimpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> findByRoleNameIgnoreCase(String roleName) {
        // Implement the query logic here using EntityManager
        return null;  // Replace with your query logic
    }
}

