package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findByMobileNumber(String mobileNumber);

    User findByFirstNameAndLastName(String firstName, String lastName);

    User findByFirstName(String firstName);
}
