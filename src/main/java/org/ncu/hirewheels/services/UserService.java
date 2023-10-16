package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.User;

public interface UserService {
    //login
    public User login(String email, String password);

    //register
    public User register(String firstName, String lastName, String password, String email, String mobileNo);

    // get user by email
    public User getUser(String email);

    // get user by id
    public User getUser(int id);

    // get user by mobile number
    public User getUserByMobileNumber(String mobileNumber);

    // get user by first name and last name
    public User getUserByFirstNameAndLastName(String firstName, String lastName);

    // get user by first name
    public User getUserByFirstName(String firstName);



}
