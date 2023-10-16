package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.repository.RoleRepository;
import org.ncu.hirewheels.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User register(String firstName, String lastName, String password, String email, String mobileNo) {
        System.out.println("======> " + firstName + " " + lastName + " " + password + " " + email + " " + mobileNo + " <======");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobileNumber(mobileNo);
        user.setWalletMoney(10000.00);

        Role userRole = roleRepository.findByRoleName("USER");
        System.out.println("userRole: " + userRole);
        user.setRole(userRole);

        userRepository.save(user);

        return user;
    }

    @Override
    public User getUserByCriteria(Long id, String email, String mobileNumber, String firstName, String lastName) {
        if (id != null) {
            return userRepository.findById(Math.toIntExact(id)).orElse(null);
        } else if (email != null) {
            return userRepository.findByEmail(email);
        } else if (mobileNumber != null) {
            return userRepository.findByMobileNumber(mobileNumber);
        } else if (firstName != null && lastName != null) {
            return userRepository.findByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            return userRepository.findByFirstName(firstName);
        }
        // Add more criteria as needed
        return null;
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

}