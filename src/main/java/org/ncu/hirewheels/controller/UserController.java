package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/hirewheels/v1")
public class UserController {
    @Autowired
    UserService userService;

    //login
    @PostMapping(value = "/users/login")
    public ResponseEntity<String> login(@RequestBody String email, String password) {
        if (userService.getUser(email) == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        User loggedInUser = userService.login(email, password);
        if (loggedInUser == null) {
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
        }

        System.out.println("loggedInUser: " + loggedInUser);
        return new ResponseEntity<>("Logged In", HttpStatus.OK);
    }

    //register
    @PostMapping(value = "/users")
    public ResponseEntity<User> register(@RequestBody User user) {
        User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getMobileNumber());
        if (newUser == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("newUser: " + newUser);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    //get user by email
    @GetMapping(value = "/users/{email}")
    public ResponseEntity<User> getUser(@PathVariable("email") String email) {
        User user = userService.getUser(email);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("user: " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //get user by id
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("user: " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //get user by mobile number
    @GetMapping(value = "/users/{mobileNumber}")
    public ResponseEntity<User> getUserByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) {
        User user = userService.getUserByMobileNumber(mobileNumber);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("user: " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //get user by first name and last name
    @GetMapping(value = "/users/{firstName}/{lastName}")
    public ResponseEntity<User> getUserByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        User user = userService.getUserByFirstNameAndLastName(firstName, lastName);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("user: " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //get user by first name
    @GetMapping(value = "/users/{firstName}")
    public ResponseEntity<User> getUserByFirstName(@PathVariable("firstName") String firstName) {
        User user = userService.getUserByFirstName(firstName);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }

        System.out.println("user: " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
