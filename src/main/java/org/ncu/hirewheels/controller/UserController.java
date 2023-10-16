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

    @GetMapping("/search")
    public ResponseEntity<User> getUser(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String mobileNumber,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        User user = userService.getUserByCriteria(id, email, mobileNumber, firstName, lastName);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
