package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.User;

public interface UserService {
    //login
    public User login(String email, String password);

    //register
    public User register(String firstName, String lastName, String password, String email, String mobileNo);

    // get user by criteria
    public User getUserByCriteria(Long id, String email, String mobileNumber, String firstName, String lastName);

    // get user by email
    public User getUser(String email);
}
